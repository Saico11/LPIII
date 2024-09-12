import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Elegir el canal de notificación (correo o SMS)
        CanalNotificacion canalNotificacion = new EnviadorCorreo(); // O usar EnviadorSMS
        Controlador controlador = new Controlador(canalNotificacion);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean salir = false;

        while (!salir) {
            System.out.println("Sistema de Gestión de Reservas");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Reserva");
            System.out.println("3. Consultar Historial de Reservas");
            System.out.println("4. Asignar Personal de Limpieza");
            System.out.println("5. Consultar Cargas de Trabajo del Personal de Limpieza");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    controlador.registrarCliente(dni, nombre);
                    break;
                case 2:
                    System.out.print("Ingrese el DNI del cliente: ");
                    dni = scanner.nextLine();
                    System.out.print("Ingrese el código de la habitación: ");
                    String codigoHabitacion = scanner.nextLine();
                    System.out.print("Ingrese la fecha de inicio (dd/MM/yyyy): ");
                    String fechaInicioStr = scanner.nextLine();
                    System.out.print("Ingrese la fecha de fin (dd/MM/yyyy): ");
                    String fechaFinStr = scanner.nextLine();

                    try {
                        System.out.println("Seleccione la política de cancelación:");
                        System.out.println("1. Flexible");
                        System.out.println("2. Moderada");
                        System.out.println("3. Estricta");
                        int tipoPolitica = scanner.nextInt();
                        scanner.nextLine();  // Limpiar buffer

                        PoliticaCancelacion politica;
                        if (tipoPolitica == 1) {
                            politica = new PoliticaCancelacionFlexible();
                        } else if (tipoPolitica == 2) {
                            politica = new PoliticaCancelacionModerada();
                        } else {
                            politica = new PoliticaCancelacionEstricta();
                        }

                        controlador.registrarReserva(dni, codigoHabitacion, sdf.parse(fechaInicioStr), sdf.parse(fechaFinStr), politica);
                    } catch (ParseException e) {
                        System.out.println("Error en el formato de fecha. Intente de nuevo.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el DNI del cliente: ");
                    dni = scanner.nextLine();
                    controlador.consultarHistorialReservas(dni);
                    break;
                case 4:
                    System.out.print("Ingrese el DNI del personal de limpieza: ");
                    String dniLimpieza = scanner.nextLine();
                    System.out.print("Ingrese el código de la habitación: ");
                    codigoHabitacion = scanner.nextLine();
                    controlador.asignarLimpieza(dniLimpieza, codigoHabitacion);
                    break;
                case 5:
                    System.out.print("Ingrese el DNI del personal de limpieza: ");
                    dniLimpieza = scanner.nextLine();
                    PersonalLimpieza personalLimpieza = controlador.getPersonalLimpieza(dniLimpieza);
                    if (personalLimpieza != null) {
                        personalLimpieza.generarReporteCargasTrabajo();
                    } else {
                        System.out.println("Personal de limpieza no encontrado.");
                    }
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
