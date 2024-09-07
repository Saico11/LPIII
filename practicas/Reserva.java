import java.util.*;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(Habitacion habitacion, Cliente cliente, Date fechaInicio, Date fechaFin) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean conflictCon(Date inicio, Date fin) {
        return true;
    }

    // Getters y setters
}
