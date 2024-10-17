public class Pedido {
    private String nombrePlato;
    private String tipoPlato; // Nuevo atributo para el tipo de plato

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato; // Nuevo método para obtener el tipo de plato
    }
}
