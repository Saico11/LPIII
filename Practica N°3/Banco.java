public class Banco {
    public static void main(String[] args) {
        try {
            // Creación de cuentas
            CuentaBancaria cuenta1 = new CuentaBancaria("123456", "Juan Pérez", 1000);
            CuentaBancaria cuenta2 = new CuentaBancaria("654321", "María López", 2000);
            CuentaCredito cuenta3 = new CuentaCredito("789101", "Carlos Gómez", 500, 1000);

            // Operaciones
            cuenta1.depositar(500);
            cuenta1.retirar(300);

            cuenta1.transferir(cuenta2, 200);

            // Cerrar cuenta
            cuenta1.cerrarCuenta();  // Lanza excepción si el saldo no es cero

            // Reporte de transacciones
            ReporteTransacciones reporte = new ReporteTransacciones();
            reporte.generarReporte(cuenta1);
            reporte.leerReporte("reporte_123456.txt");

        } catch (IllegalArgumentException | SaldoInsuficienteException | CuentaNoEncontradaException |
                 SaldoNoCeroException | IOException | HistorialVacioException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
