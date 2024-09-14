import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReporteTransacciones {

    public void generarReporte(CuentaBancaria cuenta) throws IOException, HistorialVacioException {
        if (cuenta.getSaldo() == 0) {
            throw new HistorialVacioException("No hay transacciones para reportar.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reporte_" + cuenta.getNumeroCuenta() + ".txt"))) {
            writer.write("Número de cuenta: " + cuenta.getNumeroCuenta() + "\n");
            writer.write("Titular: " + cuenta.getTitular() + "\n");
            writer.write("Saldo: " + cuenta.getSaldo() + "\n");
        }
    }

    public void leerReporte(String nombreArchivo) throws IOException {
        try (Scanner scanner = new Scanner(new java.io.File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo: " + e.getMessage());
        }
    }
}
