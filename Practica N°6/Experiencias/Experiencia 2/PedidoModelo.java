import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

   
    public boolean eliminarPedido(String nombrePlato) {
        return pedidos.removeIf(pedido -> pedido.getNombrePlato().equalsIgnoreCase(nombrePlato));
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

  
    public List<Pedido> buscarPedido(String criterio) {
        return pedidos.stream()
            .filter(pedido -> pedido.getNombrePlato().equalsIgnoreCase(criterio) ||
                              pedido.getTipoPlato().equalsIgnoreCase(criterio))
            .collect(Collectors.toList());
    }

 
    public int contarPedidos() {
        return pedidos.size();
    }

    public int contarPedidosPorTipo(String tipo) {
        return (int) pedidos.stream()
            .filter(pedido -> pedido.getTipoPlato().equalsIgnoreCase(tipo))
            .count();
    }
}
