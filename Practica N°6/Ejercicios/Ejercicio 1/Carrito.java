import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private double descuento;
    private double costoEnvio;

    public Carrito() {
        productos = new ArrayList<>();
        descuento = 0;
        costoEnvio = 5.0; // Costo de envío por defecto
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        total = total - descuento + costoEnvio;
        return total;
    }

    public void aplicarDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void calcularEnvio(double costo) {
        this.costoEnvio = costo;
    }
}
