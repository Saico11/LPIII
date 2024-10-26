public class Main {
    public static void main(String[] args) {
        EmpleadoModel modelo = new EmpleadoModel();
        EmpleadoView vista = new EmpleadoView();
        EmpleadoController controlador = new EmpleadoController(modelo, vista);
        controlador.iniciar();
    }
}
