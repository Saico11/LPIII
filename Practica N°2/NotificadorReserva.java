public class NotificadorReserva {
    private CanalNotificacion canal;

    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    public void enviarNotificacion(String mensaje) {
        canal.enviar(mensaje);
    }
}
