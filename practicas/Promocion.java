import java.util.Date;

public class Promocion {
    private Date fechaInicio;
    private Date fechaFin;
    private double porcentajeDescuento;

    // Constructor
    public Promocion(Date fechaInicio, Date fechaFin, double porcentajeDescuento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Método para verificar si la promoción es aplicable en un rango de fechas dado
    public boolean esAplicable(Date fechaInicio, Date fechaFin) {
        return (this.fechaInicio.before(fechaFin) && this.fechaFin.after(fechaInicio));
    }

    // Método para calcular el descuento sobre un precio base
    public double getDescuento(double precioBase) {
        return precioBase * (porcentajeDescuento / 100);
    }

    // Getters y setters
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

}
