import java.util.*;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;
    private List<String> calendarioPromociones;

    public GestorDisponibilidadHabitacion() {
        this.reservas = new ArrayList<>();
        this.calendarioPromociones = new ArrayList<>();
        // Datos de ejemplo
        calendarioPromociones.add("2024-12-25");
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, String fechaInicio, String fechaFin) {
        // Lógica simplificada para verificar disponibilidad
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && 
                ((fechaInicio.compareTo(reserva.getFechaFin()) <= 0) && (fechaFin.compareTo(reserva.getFechaInicio()) >= 0))) {
                return false;
            }
        }
        return true;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<String> getCalendarioPromociones() {
        return calendarioPromociones;
    }
}
