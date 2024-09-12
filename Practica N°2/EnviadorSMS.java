public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
        // Lógica de envío de SMS
    }
}
