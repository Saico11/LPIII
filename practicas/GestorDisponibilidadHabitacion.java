import java.util.*;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> reservas;
    private List<Promocion> promociones;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public GestorDisponibilidadHabitacion(List<Reserva> reservas, List<Promocion> promociones) {
        this.reservas = reservas;
        this.promociones = promociones;
    }

    public Habitacion(GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public boolean verificarDisponibilidad(Habitacion habitacion, Date inicio, Date fin) {
        for (Reserva reserva : reservas) {
            if (reserva.conflictaCon(inicio, fin)) {
                return false;
            }
        }
        return habitacion.isDisponible();
    }

    public void actualizarEstadoHabitacion(Habitacion habitacion, boolean reservado) {
        if (reservado) {
            habitacion.marcarComoReservada();
        } else {
            habitacion.marcarComoDisponible();
        }
    }
}
