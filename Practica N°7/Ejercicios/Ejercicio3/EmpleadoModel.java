import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModel {
    private final String archivo = "empleados.dat";

    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (List<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return empleados;
    }

    public void guardarEmpleados(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    public Empleado buscarEmpleado(int numero) {
        return leerEmpleados().stream()
                .filter(e -> e.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public void agregarEmpleado(Empleado nuevoEmpleado) {
        List<Empleado> empleados = leerEmpleados();
        empleados.add(nuevoEmpleado);
        guardarEmpleados(empleados);
    }

    public boolean eliminarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados(empleados);
        }
        return eliminado;
    }
}
