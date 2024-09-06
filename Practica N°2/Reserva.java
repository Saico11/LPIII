public class Reserva {
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;
    private PoliticaCancelacion politicaCancelacion;
    private String notificacion;

    public Reserva(Habitacion habitacion, String fechaInicio, String fechaFin, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void cancelarReserva() {
        System.out.println("Reserva cancelada.");
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }
}
