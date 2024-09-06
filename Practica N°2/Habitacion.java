public class Habitacion {
    private String tipo;
    private double precio;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(String tipo, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }
}
