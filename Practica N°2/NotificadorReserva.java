public class NotificadorReserva {
    private CanalNotificacion canalNotificacion;

    public NotificadorReserva(CanalNotificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    public void notificar(String mensaje) {
        canalNotificacion.enviarNotificacion(mensaje);
    }
}
