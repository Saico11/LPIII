import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\nMenú de Opciones:");
        System.out.println("1. Agregar Producto al Carrito");
        System.out.println("2. Ver Carrito");
        System.out.println("3. Eliminar Producto del Carrito");
        System.out.println("4. Aplicar Descuento");
        System.out.println("5. Calcular Envío");
        System.out.println("6. Ver Historial de Compras");
        System.out.println("7. Realizar Compra");
        System.out.println("8. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public String solicitarNombreProducto() {
        System.out.print("Introduce el nombre del producto: ");
        return scanner.nextLine();
    }

    public double solicitarPrecioProducto() {
        System.out.print("Introduce el precio del producto: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarCarrito(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
            }
        }
    }

    public void mostrarTotal(double total) {
        System.out.println("Total a pagar: $" + total);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public double solicitarDescuento() {
        System.out.print("Introduce el monto del descuento: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public double solicitarCostoEnvio() {
        System.out.print("Introduce el costo del envío: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarHistorial(List<Carrito> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay historial de compras.");
        } else {
            System.out.println("Historial de Compras:");
            for (Carrito carrito : historial) {
                mostrarCarrito(carrito.getProductos());
                mostrarTotal(carrito.calcularTotal());
            }
        }
    }
}
