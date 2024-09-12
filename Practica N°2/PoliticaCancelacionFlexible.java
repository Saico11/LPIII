public class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    @Override
    public double calcularPenalidad(Reserva reserva) {
        return 0; // Sin penalidad si cancela con anticipación
    }
}