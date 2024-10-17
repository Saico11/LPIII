public class Item {
    private String nombre;
    private String tipo; 
    private String descripcion;
    private int cantidad;

    public Item(String nombre, String tipo, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void usar() {
        if (cantidad > 0) {
            cantidad--;
            System.out.println("Has usado " + nombre + ". Quedan " + cantidad + " en tu inventario.");
        } else {
            System.out.println("No tienes más de este ítem.");
        }
    }
}
