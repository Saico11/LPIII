// Clase Profesor que hereda de Persona
public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + getNombre() + ", DNI: " + getDni() + ", Especialidad: " + especialidad);
    }
}
