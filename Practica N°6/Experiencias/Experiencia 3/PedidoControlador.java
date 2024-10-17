import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
        }
    }

    public void eliminarPedido(String nombrePlato) {
        if (modelo.eliminarPedido(nombrePlato)) {
            vista.mostrarMensaje("Pedido eliminado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    public void actualizarPedido(String nombrePlato, String nuevoNombrePlato) {
        if (modelo.actualizarPedido(nombrePlato, nuevoNombrePlato)) {
            vista.mostrarMensaje("Pedido actualizado a: " + nuevoNombrePlato);
        } else {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    public void marcarPedidoComoCompleto(String nombrePlato) {
        if (modelo.marcarPedidoComoCompleto(nombrePlato)) {
            vista.mostrarMensaje("Pedido marcado como completo: " + nombrePlato);
        } else {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    public void mostrarPedidosPorEstado(String estado) {
        List<Pedido> pedidos = modelo.obtenerPedidosPorEstado(estado);
        vista.mostrarPedidos(pedidos);
    }

    public void contarPedidosPendientes() {
        int totalPendientes = modelo.contarPedidosPendientes();
        vista.mostrarMensaje("Total de pedidos pendientes: " + totalPendientes);
    }

    public void mostrarHistorial() {
        List<Pedido> historial = modelo.getHistorial();
        if (historial.isEmpty()) {
            vista.mostrarMensaje("No hay historial de pedidos.");
        } else {
            vista.mostrarMensaje("Historial de Pedidos:");
            for (Pedido pedido : historial) {
                vista.mostrarMensaje("- " + pedido.getNombrePlato() + " (" + pedido.getTipoPlato() + ") - " + pedido.getEstado());
            }
        }
    }

    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }    

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombrePlato();
                    eliminarPedido(nombreEliminar);
                    break;
                case "4":
                    String nombreActualizar = vista.solicitarNombrePlato();
                    String nuevoNombrePlato = vista.solicitarNombrePlato();
                    actualizarPedido(nombreActualizar, nuevoNombrePlato);
                    break;
                case "5":
                    String nombreCompleto = vista.solicitarNombrePlato();
                    marcarPedidoComoCompleto(nombreCompleto);
                    break;
                case "6":
                    contarPedidosPendientes();
                    break;
                case "7":
                    mostrarHistorial();
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("9"));
        vista.cerrarScanner();
    }    
}
