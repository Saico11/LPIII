import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(Habitacion habitacion, Cliente cliente, Date fechaInicio, Date fechaFin, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double calcularPenalidadCancelacion() {
        return politicaCancelacion.calcularPenalidad(this);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Reserva: " + habitacion.getCodigo() + ", Cliente: " + cliente.getNombre() + ", Desde: " + sdf.format(fechaInicio) + " Hasta: " + sdf.format(fechaFin);
    }
}
    