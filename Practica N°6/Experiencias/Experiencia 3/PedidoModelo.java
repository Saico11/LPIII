import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial; // Nuevo atributo para el historial de pedidos

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Eliminar un pedido
    public boolean eliminarPedido(String nombrePlato) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                pedido.marcarComoEliminado(); // Marca como eliminado
                historial.add(pedido); // Agrega al historial
                return pedidos.remove(pedido);
            }
        }
        return false;
    }

    public boolean actualizarPedido(String nombrePlato, String nuevoNombrePlato) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                pedidos.remove(pedido);
                pedidos.add(new Pedido(nuevoNombrePlato, pedido.getTipoPlato()));
                return true;
            }
        }
        return false;
    }
    
    // Marcar un pedido como completo
    public boolean marcarPedidoComoCompleto(String nombrePlato) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                pedido.marcarComoCompleto();
                return true;
            }
        }
        return false;
    }

    public List<Pedido> obtenerPedidosPorEstado(String estado) {
        return pedidos.stream()
            .filter(pedido -> pedido.getEstado().equalsIgnoreCase(estado)) // Filtra por estado
            .collect(Collectors.toList());
    }
    
    

    // Contar pedidos pendientes
    public int contarPedidosPendientes() {
        return (int) pedidos.stream()
            .filter(pedido -> pedido.getEstado().equalsIgnoreCase("Pendiente"))
            .count();
    }

    // Obtener historial de pedidos
    public List<Pedido> getHistorial() {
        return historial;
    }
}
