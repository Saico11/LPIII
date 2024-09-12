public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo: " + mensaje);
        // Lógica de envío de correo
    }
}
