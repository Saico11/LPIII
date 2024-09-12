import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni;
    private String nombre;
    private List<Reserva> historialReservas;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.historialReservas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    // Método para generar un reporte del historial de reservas del cliente
    public void generarReporteHistorial() {
        System.out.println("Historial de Reservas de " + nombre + " (DNI: " + dni + "):");
        for (Reserva reserva : historialReservas) {
            System.out.println(reserva);
        }
    }
}
