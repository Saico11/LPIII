public class Reserva {
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(Habitacion habitacion, String fechaInicio, String fechaFin, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
    }

    public void cancelarReserva() {
        if (politicaCancelacion.puedeCancelar(this)) {
            System.out.println("Reserva cancelada.");
        } else {
            System.out.println("No se puede cancelar la reserva.");
        }
    }

    // Getters y Setters
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
}
