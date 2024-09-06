public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        // Lógica para enviar correo electrónico
        System.out.println("Enviando correo: " + mensaje);
    }
}
