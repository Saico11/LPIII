import java.util.*;

public class Habitacion {
    private Date fechaEntrada;
    private Date fechaSalida;
    private boolean disponible;
    private double precioBase;
    private List<Reserva> reservas;
    private List<Promocion> promociones;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public boolean verificarDisponibilidad(Date inicio, Date fin) {
        return gestorDisponibilidad.verificarDisponibilidad(this, inicio, fin);
    }

    public void marcarComoReservada() {
        gestorDisponibilidad.actualizarEstadoHabitacion(this, true);
    }

    public void marcarComoDisponible() {
        gestorDisponibilidad.actualizarEstadoHabitacion(this, false);
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    public double calcularPrecio(Date fechaEntrada, Date fechaSalida) {
        double precio = precioBase;
        for (Promocion promocion : promociones) {
            if (promocion.esAplicable(fechaEntrada, fechaSalida)) {
                precio -= promocion.getDescuento(precio);
            }
        }
        return precio;
    }

    public InformeOcupacion generarInformeOcupacion() {
        InformeOcupacion informe = new InformeOcupacion();
        return informe;
    }
}
