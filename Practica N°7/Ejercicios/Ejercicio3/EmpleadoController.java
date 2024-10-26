import java.util.List;

public class EmpleadoController {
    private final EmpleadoModel modelo;
    private final EmpleadoView vista;

    public EmpleadoController(EmpleadoModel modelo, EmpleadoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void listarEmpleados() {
        List<Empleado> empleados = modelo.leerEmpleados();
        if (empleados.isEmpty()) {
            vista.mostrarMensaje("No hay empleados registrados.");
        } else {
            empleados.forEach(e -> vista.mostrarMensaje(e.toString()));
        }
    }

    private void agregarEmpleado() {
        Empleado nuevoEmpleado = vista.ingresarEmpleado();
        modelo.agregarEmpleado(nuevoEmpleado);
        vista.mostrarMensaje("Empleado agregado exitosamente.");
    }

    private void buscarEmpleado() {
        int numero = vista.leerNumeroEmpleado();
        Empleado empleado = modelo.buscarEmpleado(numero);
        vista.mostrarEmpleado(empleado);
    }

    private void eliminarEmpleado() {
        int numero = vista.leerNumeroEmpleado();
        boolean eliminado = modelo.eliminarEmpleado(numero);
        if (eliminado) {
            vista.mostrarMensaje("Empleado eliminado exitosamente.");
        } else {
            vista.mostrarMensaje("Empleado no encontrado.");
        }
    }
}
