import java.util.Scanner;

public class GestionProductos {
    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Consultar productos");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    consultarProductos(gestor, scanner);
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void consultarProductos(GestorProductos gestor, Scanner scanner) {
        System.out.print("Campos a mostrar (id, nombre, precio, cantidad): ");
        String campos = scanner.nextLine();
        System.out.print("Condición (campo=valor) o dejar vacío: ");
        String condicion = scanner.nextLine();
        System.out.print("Campo para ordenar (id, nombre, precio, cantidad): ");
        String ordenarPor = scanner.nextLine();
        System.out.print("¿Descendente? (true/false): ");
        boolean descendente = scanner.nextBoolean();
        System.out.print("Límite de registros a mostrar: ");
        int limite = scanner.nextInt();

        gestor.consultarProductos(campos, condicion, ordenarPor, descendente, limite);
    }
}
