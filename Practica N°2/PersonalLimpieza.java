import java.util.HashMap;
import java.util.Map;

public class PersonalLimpieza {
    private String dni;
    private String nombre;
    private Map<String, Habitacion> habitacionesAsignadas;

    public PersonalLimpieza(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.habitacionesAsignadas = new HashMap<>();
    }

    public String getDni() {
        return dni;
    }

    public void asignarHabitacion(Habitacion habitacion) {
        habitacionesAsignadas.put(habitacion.getCodigo(), habitacion);
        System.out.println("Habitación " + habitacion.getCodigo() + " asignada al personal " + nombre);
    }

    public void generarReporteCargasTrabajo() {
        if (habitacionesAsignadas.isEmpty()) {
            System.out.println("El personal " + nombre + " no tiene habitaciones asignadas.");
        } else {
            System.out.println("Habitaciones asignadas al personal " + nombre + ":");
            for (Habitacion habitacion : habitacionesAsignadas.values()) {
                System.out.println("Código de habitación: " + habitacion.getCodigo());
            }
        }
    }
}
