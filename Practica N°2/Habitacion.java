public class Habitacion {
    private String tipo;
    private double precio;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(String tipo, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.gestorDisponibilidad = gestorDisponibilidad;
    }

    public double calcularPrecio() {
        // Lógica simplificada para calcular el precio según la temporada
        return precio;
    }

    public void asignarHabitacion() {
        // Lógica para asignar la habitación
        System.out.println("Habitación asignada: " + tipo);
    }

    public void liberarHabitacion() {
        // Lógica para liberar la habitación
        System.out.println("Habitación liberada: " + tipo);
    }

    public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) {
        return gestorDisponibilidad.verificarDisponibilidad(this, fechaInicio, fechaFin);
    }

    public void reservarHabitacion() {
        // Lógica para reservar la habitación
        System.out.println("Habitación reservada: " + tipo);
    }

    // Getters y Setters
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

