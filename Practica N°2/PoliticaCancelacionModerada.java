public class PoliticaCancelacionModerada implements PoliticaCancelacion {
    @Override
    public double calcularPenalidad(Reserva reserva) {
        return 50; // Penalidad moderada
    }
}