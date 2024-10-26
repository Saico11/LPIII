import java.util.Scanner;

public class EmpleadoView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por su número");
        System.out.println("4. Eliminar un empleado por su número");
        System.out.println("5. Salir");
    }

    public int leerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Empleado ingresarEmpleado() {
        System.out.print("Ingrese el número de empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el nombre de empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    public int leerNumeroEmpleado() {
        System.out.print("Ingrese el número de empleado: ");
        return scanner.nextInt();
    }

    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
