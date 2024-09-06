public class Controlador {
    private GestorDisponibilidadHabitacion gestorDisponibilidad;
    private Reserva reservaActual;

    public Controlador(GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public void crearReserva(Habitacion habitacion, String fechaInicio, String fechaFin, PoliticaCancelacion politicaCancelacion) {
        reservaActual = new Reserva(habitacion, fechaInicio, fechaFin, politicaCancelacion);
        // Lógica para agregar la reserva al gestor de disponibilidad
        System.out.println("Reserva creada.");
    }

    public Reserva obtenerReservaActual() {
        return reservaActual;
    }

    public void notificarReserva(NotificadorReserva notificador, String mensaje) {
        if (reservaActual != null) {
            reservaActual.setNotificacion(mensaje);
            notificador.enviarNotificacion(mensaje);
        } else {
            System.out.println("No hay reservas actuales para notificar.");
        }
    }
}
