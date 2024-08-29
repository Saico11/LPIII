import java.util.*;
// Clase Curso para representar un curso universitario
public class Curso {
    // Constante para el número máximo de estudiantes por defecto
    public static final int MAX_ESTUDIANTES_DEFAULT = 30;

    private String nombre;
    private Profesor profesor;
    private Categoria categoria;
    private int maxEstudiantes;
    private ArrayList<Estudiante> estudiantes;

    // Constructor que permite especificar el número máximo de estudiantes
    public Curso(String nombre, Profesor profesor, Categoria categoria, int maxEstudiantes) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.categoria = categoria;
        this.maxEstudiantes = maxEstudiantes;
        this.estudiantes = new ArrayList<>();
    }

    // Constructor que usa el valor constante por defecto para el número máximo de estudiantes
    public Curso(String nombre, Profesor profesor, Categoria categoria) {
        this(nombre, profesor, categoria, MAX_ESTUDIANTES_DEFAULT);
    }

    public boolean inscribirEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < maxEstudiantes) {
            estudiantes.add(estudiante);
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInfoCurso() {
        System.out.println("Curso: " + nombre + ", Categoría: " + categoria.getNombreCategoria() + ", Profesor: " + profesor.getNombre());
        System.out.println("Estudiantes inscritos:");
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInfo();
        }
        System.out.println("Total de estudiantes inscritos: " + estudiantes.size());
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public int getNumEstudiantes() {
        return estudiantes.size();
    }
}
