import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("1. Agregar personaje");
            System.out.println("2. Modificar personaje");
            System.out.println("3. Actualizar atributo de personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Mostrar personajes");
            System.out.println("6. Filtrar personajes por atributo");
            System.out.println("7. Mostrar estadísticas");
            System.out.println("8. Importar personajes desde archivo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nivel: ");
                    int nivel = Integer.parseInt(scanner.nextLine());
                    System.out.print("Salud: ");
                    int salud = Integer.parseInt(scanner.nextLine());
                    System.out.print("Fuerza: ");
                    int fuerza = Integer.parseInt(scanner.nextLine());
                    gestor.agregarPersonaje(nombre, nivel, salud, fuerza);
                    break;
                case "2":
                    System.out.print("Nombre del personaje a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Nuevo Nivel: ");
                    int nuevoNivel = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nueva Salud: ");
                    int nuevaSalud = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nueva Fuerza: ");
                    int nuevaFuerza = Integer.parseInt(scanner.nextLine());
                    gestor.modificarPersonaje(nombreModificar, nuevoNivel, nuevaSalud, nuevaFuerza);
                    break;
                case "3":
                    System.out.print("Nombre del personaje: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Atributo a actualizar (nivel, salud, fuerza): ");
                    String atributo = scanner.nextLine();
                    System.out.print("Nuevo valor: ");
                    int nuevoValor = Integer.parseInt(scanner.nextLine());
                    gestor.actualizarAtributo(nombreActualizar, atributo, nuevoValor);
                    break;
                case "4":
                    System.out.print("Nombre del personaje a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestor.eliminarPersonaje(nombreEliminar);
                    break;
                case "5":
                    gestor.mostrarPersonajes();
                    break;
                case "6":
                    System.out.print("Atributo por el que filtrar (nivel, salud, fuerza): ");
                    String atributoFiltrar = scanner.nextLine();
                    gestor.filtrarPersonajesPorAtributo(atributoFiltrar);
                    break;
                case "7":
                    gestor.mostrarEstadisticas();
                    break;
                case "8":
                    System.out.print("Archivo a importar: ");
                    String archivoImportar = scanner.nextLine();
                    gestor.importarPersonajesDesdeArchivo(archivoImportar);
                    break;
                case "9":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("9"));

        scanner.close();
    }
}
