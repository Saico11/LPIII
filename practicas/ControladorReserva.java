import java.util.Date;

public class ControladorReserva {
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public ControladorReserva(GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public void crearReserva(Habitacion habitacion, Date inicio, Date fin, Cliente cliente) {
        if (gestorDisponibilidad.verificarDisponibilidad(habitacion, inicio, fin)) {
            habitacion.marcarComoReservada();


            Reserva nuevaReserva = new Reserva(habitacion, cliente, inicio, fin);
            
            System.out.println("Reserva creada con éxito para el cliente: " + cliente.getNombre());
        } else {
            System.out.println("No hay disponibilidad para las fechas seleccionadas.");
        }
    }

    public void consultarDisponibilidad(Habitacion habitacion, Date inicio, Date fin) {
        boolean disponible = gestorDisponibilidad.verificarDisponibilidad(habitacion, inicio, fin);

        if (disponible) {
            System.out.println("La habitación está disponible para las fechas seleccionadas.");
        } else {
            System.out.println("La habitación no está disponible para las fechas seleccionadas.");
        }
    }
}
