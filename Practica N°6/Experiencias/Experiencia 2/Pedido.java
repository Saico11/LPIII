public class Pedido {
    private String nombrePlato;
    private String tipoPlato;

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato; 
    }
}
