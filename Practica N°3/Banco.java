import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private static Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    retirar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    cerrarCuenta();
                    break;
                case 7:
                    generarReporte();
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DEL BANCO ---");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Transferir dinero");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Cerrar cuenta");
        System.out.println("7. Generar reporte");
        System.out.println("8. Salir");
    }

    private static void crearCuenta() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            String titular = leerTexto("Ingrese el nombre del titular: ");
            double saldoInicial = leerDouble("Ingrese el saldo inicial: ");
            System.out.println("¿Es una cuenta de crédito? (s/n): ");
            boolean esCredito = scanner.next().equalsIgnoreCase("s");
            if (esCredito) {
                double limiteCredito = leerDouble("Ingrese el límite de crédito: ");
                cuentas.put(numeroCuenta, new CuentaCredito(numeroCuenta, titular, saldoInicial, limiteCredito));
            } else {
                cuentas.put(numeroCuenta, new CuentaBancaria(numeroCuenta, titular, saldoInicial));
            }
            System.out.println("Cuenta creada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void depositar() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta == null) {
                throw new CuentaNoEncontradaException("Cuenta no encontrada.");
            }
            double monto = leerDouble("Ingrese el monto a depositar: ");
            cuenta.depositar(monto);
            System.out.println("Depósito realizado exitosamente.");
        } catch (CuentaNoEncontradaException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void retirar() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta == null) {
                throw new CuentaNoEncontradaException("Cuenta no encontrada.");
            }
            double monto = leerDouble("Ingrese el monto a retirar: ");
            cuenta.retirar(monto);
            System.out.println("Retiro realizado exitosamente.");
        } catch (CuentaNoEncontradaException | SaldoInsuficienteException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transferir() {
        try {
            String cuentaOrigen = leerTexto("Ingrese el número de cuenta de origen: ");
            CuentaBancaria origen = cuentas.get(cuentaOrigen);
            if (origen == null) {
                throw new CuentaNoEncontradaException("Cuenta de origen no encontrada.");
            }
            String cuentaDestino = leerTexto("Ingrese el número de cuenta de destino: ");
            CuentaBancaria destino = cuentas.get(cuentaDestino);
            if (destino == null) {
                throw new CuentaNoEncontradaException("Cuenta de destino no encontrada.");
            }
            double monto = leerDouble("Ingrese el monto a transferir: ");
            origen.retirar(monto);
            destino.depositar(monto);
            System.out.println("Transferencia realizada exitosamente.");
        } catch (CuentaNoEncontradaException | SaldoInsuficienteException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void consultarSaldo() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta == null) {
                throw new CuentaNoEncontradaException("Cuenta no encontrada.");
            }
            System.out.println("Saldo de la cuenta " + numeroCuenta + ": " + cuenta.getSaldo());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cerrarCuenta() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta == null) {
                throw new CuentaNoEncontradaException("Cuenta no encontrada.");
            }
            if (cuenta.getSaldo() != 0) {
                throw new SaldoNoCeroException("No se puede cerrar la cuenta con saldo positivo.");
            }
            cuentas.remove(numeroCuenta);
            System.out.println("Cuenta cerrada exitosamente.");
        } catch (CuentaNoEncontradaException | SaldoNoCeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void generarReporte() {
        try {
            String numeroCuenta = leerTexto("Ingrese el número de cuenta: ");
            CuentaBancaria cuenta = cuentas.get(numeroCuenta);
            if (cuenta == null) {
                throw new CuentaNoEncontradaException("Cuenta no encontrada.");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("reporte_" + numeroCuenta + ".txt"))) {
                writer.write("Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
                writer.write("Titular: " + cuenta.getTitular() + "\n");
                writer.write("Saldo: " + cuenta.getSaldo() + "\n");
                System.out.println("Reporte generado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al generar el reporte: " + e.getMessage());
            }
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }
}
