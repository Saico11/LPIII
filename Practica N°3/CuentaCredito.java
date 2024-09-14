public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) throws IllegalArgumentException {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo + limiteCredito) {
            throw new SaldoInsuficienteException("El monto excede el límite de crédito disponible.");
        }
        saldo -= monto;
    }
}
