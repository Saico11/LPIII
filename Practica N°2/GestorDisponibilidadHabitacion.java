import java.util.Map;

public class GestorDisponibilidadHabitacion {
    private Map<String, Habitacion> habitaciones;

    public GestorDisponibilidadHabitacion(Map<String, Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public boolean estaDisponible(String codigoHabitacion) {
        Habitacion habitacion = habitaciones.get(codigoHabitacion);
        if (habitacion == null) {
            System.out.println("Habitación no encontrada.");
            return false;
        }
        return habitacion.estaDisponible();
    }

    public void agregarReserva(String codigoHabitacion, Reserva reserva) {
        Habitacion habitacion = habitaciones.get(codigoHabitacion);
        if (habitacion != null) {
            habitacion.agregarReserva(reserva);
        }
    }
}

