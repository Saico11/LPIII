import java.util.*;

// Clase principal SistemaGestion para gestionar los cursos universitarios
public class SistemaGestion {
    // Constantes para valores predeterminados
    private static final int OPCION_SALIR = 3;

    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarSistema();

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarSubMenuCursos();
                    break;
                case 2:
                    inscribirEstudiante();
                    break;
                case OPCION_SALIR:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Cursos Universitarios ---");
        System.out.println("1. Ver cursos disponibles");
        System.out.println("2. Inscribir estudiante en un curso");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarSubMenuCursos() {
        while (true) {
            System.out.println("\n--- Cursos Disponibles ---");
            for (int i = 0; i < cursos.size(); i++) {
                Curso curso = cursos.get(i);
                System.out.println((i + 1) + ". " + curso.getNombre() + " - Profesor: " + curso.getProfesor().getNombre() + " - Estudiantes inscritos: " + curso.getNumEstudiantes());
            }
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            if (opcion == 0) {
                return; // Volver al menú principal
            } else if (opcion > 0 && opcion <= cursos.size()) {
                cursos.get(opcion - 1).mostrarInfoCurso();
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void inscribirEstudiante() {
        mostrarCursos();
        System.out.print("Seleccione un curso para inscribirse (número): ");
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir la nueva línea

        if (cursoIndex < 0 || cursoIndex >= cursos.size()) {
            System.out.println("Curso no válido.");
            return;
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del estudiante: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = scanner.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(nombre, dni, codigo);

        boolean exito = cursos.get(cursoIndex).inscribirEstudiante(nuevoEstudiante);
        if (exito) {
            System.out.println("Estudiante inscrito correctamente.");
        } else {
            System.out.println("El curso está lleno. No se pudo inscribir al estudiante.");
        }
    }

    private static void mostrarCursos() {
        System.out.println("\n--- Cursos Disponibles ---");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombre());
        }
    }

    private static void inicializarSistema() {
        Profesor profesor1 = new Profesor("Carlos Pérez", "12345678", "Matemáticas");
        Profesor profesor2 = new Profesor("María Gómez", "87654321", "Programación");

        Categoria categoria1 = new Categoria("Matemáticas");
        Categoria categoria2 = new Categoria("Programación");

        // Usando el constructor con la constante MAX_ESTUDIANTES_DEFAULT
        Curso curso1 = new Curso("Álgebra", profesor1, categoria1);
        Curso curso2 = new Curso("Java Avanzado", profesor2, categoria2, 3); // Aquí se usa un valor específico

        cursos.add(curso1);
        cursos.add(curso2);
    }
}
