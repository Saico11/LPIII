import java.util.Scanner;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancias de gestores y políticas
        GestorDisponibilidadHabitacion gestorDisponibilidad = new GestorDisponibilidadHabitacion();
        PoliticaCancelacion politicaFlexible = new PoliticaCancelacionFlexible();
        PoliticaCancelacion politicaModerada = new PoliticaCancelacionModerada();
        PoliticaCancelacion politicaEstricta = new PoliticaCancelacionEstricta();

        // Crear habitaciones
        Habitacion habitacion1 = new Habitacion("Suite", 150.0, gestorDisponibilidad);
        Habitacion habitacion2 = new Habitacion("Doble", 100.0, gestorDisponibilidad);

        // Crear controladores
        Controlador controlador = new Controlador(gestorDisponibilidad);

        // Crear notificador
        CanalNotificacion correo = new EnviadorCorreo();
        NotificadorReserva notificador = new NotificadorReserva(correo);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Reservas ---");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Mostrar Habitación Reservada");
            System.out.println("4. Notificar Reserva");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Crear reserva
                    Habitacion habitacion;
                    while (true) {
                        System.out.print("Ingrese el tipo de habitación (Suite/Doble): ");
                        String tipo = scanner.nextLine();
                        if (tipo.equalsIgnoreCase("Suite")) {
                            habitacion = habitacion1;
                            break;
                        } else if (tipo.equalsIgnoreCase("Doble")) {
                            habitacion = habitacion2;
                            break;
                        } else {
                            System.out.println("Tipo de habitación no válido. Por favor ingrese Suite o Doble.");
                        }
                    }

                    String fechaInicio;
                    String fechaFin;
                    while (true) {
                        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
                        fechaInicio = scanner.nextLine();
                        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
                        fechaFin = scanner.nextLine();

                        if (esFechaValida(fechaInicio) && esFechaValida(fechaFin)) {
                            break;
                        } else {
                            System.out.println("Fechas no válidas. Asegúrese de usar el formato YYYY-MM-DD.");
                        }
                    }

                    System.out.println("Seleccione la política de cancelación:");
                    System.out.println("1. Flexible");
                    System.out.println("2. Moderada");
                    System.out.println("3. Estricta");
                    int politica = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    PoliticaCancelacion politicaSeleccionada;
                    switch (politica) {
                        case 1:
                            politicaSeleccionada = politicaFlexible;
                            break;
                        case 2:
                            politicaSeleccionada = politicaModerada;
                            break;
                        case 3:
                            politicaSeleccionada = politicaEstricta;
                            break;
                        default:
                            System.out.println("Política de cancelación no válida. Se aplicará la política Flexible por defecto.");
                            politicaSeleccionada = politicaFlexible;
                    }

                    controlador.crearReserva(habitacion, fechaInicio, fechaFin, politicaSeleccionada);
                    System.out.println("Reserva creada con éxito.");
                    break;

                case 2:
                    // Cancelar reserva
                    System.out.println("Ingrese el tipo de habitación para cancelar la reserva (Suite/Doble): ");
                    String tipoCancelacion = scanner.nextLine();
                    habitacion = tipoCancelacion.equalsIgnoreCase("Suite") ? habitacion1 : habitacion2;

                    Reserva reserva = new Reserva(habitacion, "2024-12-20", "2024-12-25", politicaFlexible); // Datos de ejemplo
                    reserva.cancelarReserva();
                    System.out.println("Reserva cancelada con éxito.");
                    break;

                case 3:
                    // Mostrar habitación reservada
                    Reserva reservaActual = controlador.obtenerReservaActual(); // Asumiendo que el controlador tiene un método para obtener la reserva actual
                    if (reservaActual != null) {
                        System.out.println("Habitación reservada:");
                        System.out.println("Tipo: " + reservaActual.getHabitacion().getTipo());
                        System.out.println("Fecha de inicio: " + reservaActual.getFechaInicio());
                        System.out.println("Fecha de fin: " + reservaActual.getFechaFin());
                        System.out.println("Política de cancelación: " + reservaActual.getPoliticaCancelacion().getClass().getSimpleName());
                        System.out.println("Notificación enviada: " + reservaActual.getNotificacion());
                    } else {
                        System.out.println("No hay reservas actuales.");
                    }
                    break;

                case 4:
                    // Notificar reserva
                    System.out.print("Ingrese el mensaje de notificación: ");
                    String mensaje = scanner.nextLine();
                    controlador.notificarReserva(notificador, mensaje);
                    System.out.println("Notificación enviada.");
                    break;

                case 5:
                    // Salir
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }

    // Método para validar el formato de la fecha (YYYY-MM-DD)
    private static boolean esFechaValida(String fecha) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(regex, fecha);
    }
}
