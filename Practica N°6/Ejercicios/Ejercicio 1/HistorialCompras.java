import java.util.ArrayList;
import java.util.List;

public class HistorialCompras {
    private List<Carrito> historial;

    public HistorialCompras() {
        historial = new ArrayList<>();
    }

    public void agregarCompra(Carrito carrito) {
        historial.add(carrito);
    }

    public List<Carrito> getHistorial() {
        return historial;
    }
}
