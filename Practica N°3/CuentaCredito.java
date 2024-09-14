public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo + limiteCredito) {
            throw new LimiteCreditoExcedidoException("El monto excede el límite de crédito disponible.");
        }
        saldo -= monto;
    }
}
