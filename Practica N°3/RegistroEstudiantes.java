import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private ArrayList<String> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    // Método para agregar estudiante, lanzando IllegalArgumentException si el nombre es nulo o vacío
    public void agregarEstudiante(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
    }

    // Método para buscar estudiante, lanzando NoSuchElementException si no está en el registro
    public String buscarEstudiante(String nombre) throws NoSuchElementException {
        if (estudiantes.contains(nombre)) {
            return nombre;
        } else {
            throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
        }
    }

    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            registro.agregarEstudiante("Juan");
            registro.agregarEstudiante("Maria");
            registro.agregarEstudiante("");  // Provocará la excepción

            System.out.println("Estudiante encontrado: " + registro.buscarEstudiante("Maria"));
            System.out.println("Estudiante encontrado: " + registro.buscarEstudiante("Carlos"));  // Provocará la excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
