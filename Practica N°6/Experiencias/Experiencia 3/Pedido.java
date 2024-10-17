public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado; // Nuevo atributo para el estado del pedido

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "Pendiente"; // Estado inicial
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public String getEstado() {
        return estado; // Nuevo método para obtener el estado
    }

    public void marcarComoCompleto() {
        this.estado = "Completo"; // Cambia el estado a "Completo"
    }

    public void marcarComoEliminado() {
        this.estado = "Eliminado"; // Cambia el estado a "Eliminado"
    }
}
