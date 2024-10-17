public class Main {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        CarritoVista vista = new CarritoVista();
        HistorialCompras historial = new HistorialCompras();
        CarritoControlador controlador = new CarritoControlador(carrito, vista, historial);
        controlador.iniciar();
    }
}
