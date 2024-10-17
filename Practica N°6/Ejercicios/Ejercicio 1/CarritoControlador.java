public class CarritoControlador {
    private Carrito carrito;
    private CarritoVista vista;
    private HistorialCompras historial;

    public CarritoControlador(Carrito carrito, CarritoVista vista, HistorialCompras historial) {
        this.carrito = carrito;
        this.vista = vista;
        this.historial = historial;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombreProducto = vista.solicitarNombreProducto();
                    double precioProducto = vista.solicitarPrecioProducto();
                    carrito.agregarProducto(new Producto(nombreProducto, precioProducto));
                    vista.mostrarMensaje("Producto agregado al carrito.");
                    break;
                case "2":
                    vista.mostrarCarrito(carrito.getProductos());
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombreProducto();
                    carrito.eliminarProducto(nombreEliminar);
                    vista.mostrarMensaje("Producto eliminado del carrito.");
                    break;
                case "4":
                    double descuento = vista.solicitarDescuento();
                    carrito.aplicarDescuento(descuento);
                    vista.mostrarMensaje("Descuento aplicado.");
                    break;
                case "5":
                    double costoEnvio = vista.solicitarCostoEnvio();
                    carrito.calcularEnvio(costoEnvio);
                    vista.mostrarMensaje("Costo de envío actualizado.");
                    break;
                case "6":
                    vista.mostrarHistorial(historial.getHistorial());
                    break;
                case "7":
                    vista.mostrarTotal(carrito.calcularTotal());
                    historial.agregarCompra(carrito);
                    carrito = new Carrito(); // Reinicia el carrito
                    vista.mostrarMensaje("Compra realizada con éxito.");
                    break;
                case "8":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("8"));
    }
}
