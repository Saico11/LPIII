public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException, CuentaNoEncontradaException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }
        this.retirar(monto);
        destino.depositar(monto);
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta, el saldo no es cero.");
        }
        System.out.println("La cuenta " + numeroCuenta + " ha sido cerrada.");
    }
}
