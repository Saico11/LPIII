public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        // Lógica para enviar SMS
        System.out.println("Enviando SMS: " + mensaje);
    }
}
