import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        System.out.println("\nInventario:");
        for (Item item : items) {
            System.out.println(item.getNombre() + " - Tipo: " + item.getTipo() + " - Cantidad: " + item.getCantidad());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        System.out.println("Detalles del Item:");
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripción: " + item.getDescripcion());
        System.out.println("Cantidad: " + item.getCantidad());
    }
}
