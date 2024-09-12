public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public double calcularPenalidad(Reserva reserva) {
        return 100; // Penalidad estricta
    }
}