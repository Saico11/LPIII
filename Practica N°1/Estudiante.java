public class Estudiante extends Persona {
    private String codigoEstudiante;

    public Estudiante(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni);
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante: " + getNombre() + ", DNI: " + getDni() + ", Código: " + codigoEstudiante);
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }
}
