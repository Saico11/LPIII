public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado; 

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "Pendiente";
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public String getEstado() {
        return estado;
    }

    public void marcarComoCompleto() {
        this.estado = "Completo"; 
    }

    public void marcarComoEliminado() {
        this.estado = "Eliminado"; 
    }
}
