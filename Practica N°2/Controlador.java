public class Controlador {
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Controlador(GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public void crearReserva(Habitacion habitacion, String fechaInicio, String fechaFin, PoliticaCancelacion politicaCancelacion) {
        if (habitacion.verificarDisponibilidad(fechaInicio, fechaFin)) {
            Reserva reserva = new Reserva(habitacion, fechaInicio, fechaFin, politicaCancelacion);
            gestorDisponibilidad.agregarReserva(reserva);
            habitacion.reservarHabitacion();
            System.out.println("Reserva creada con éxito.");
        } else {
            System.out.println("No hay disponibilidad para las fechas seleccionadas.");
        }
    }

    public void notificarReserva(NotificadorReserva notificador, String mensaje) {
        notificador.notificar(mensaje);
    }
}
