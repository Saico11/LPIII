import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("1. Agregar personaje");
            System.out.println("2. Modificar personaje");
            System.out.println("3. Eliminar personaje");
            System.out.println("4. Mostrar personajes");
            System.out.println("5. Salir");
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
                    nombre = scanner.nextLine();
                    System.out.print("Nuevo nivel: ");
                    nivel = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nueva salud: ");
                    salud = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nueva fuerza: ");
                    fuerza = Integer.parseInt(scanner.nextLine());
                    gestor.modificarPersonaje(nombre, nivel, salud, fuerza);
                    break;
                case "3":
                    System.out.print("Nombre del personaje a eliminar: ");
                    nombre = scanner.nextLine();
                    gestor.eliminarPersonaje(nombre);
                    break;
                case "4":
                    gestor.mostrarPersonajes();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("5"));

        scanner.close();
    }
}
