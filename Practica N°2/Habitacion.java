import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String codigo;
    private double precio;
    private List<Reserva> reservas;
    private PersonalLimpieza personalLimpieza;

    public Habitacion(String codigo, double precio, List<Reserva> reservas) {
        this.codigo = codigo;
        this.precio = precio;
        this.reservas = new ArrayList<>();
        this.reservas = reservas;
    }

    public void asignarPersonalLimpieza(PersonalLimpieza personal) {
        this.personalLimpieza = personal;
        System.out.println("Personal de limpieza asignado a la habitación " + codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean estaDisponible() {
        return reservas.isEmpty(); // Disponible si no tiene reservas
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}

