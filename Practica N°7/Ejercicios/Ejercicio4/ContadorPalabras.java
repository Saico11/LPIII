import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ContadorPalabras {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto");
        
        // Mostrar el diálogo para seleccionar un archivo
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            procesarArchivo(archivo);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private static void procesarArchivo(File archivo) {
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length(); // Contar caracteres de la línea
                
                // Separar la línea en palabras
                String[] palabrasLinea = linea.split("\\s+");
                palabras += palabrasLinea.length; // Contar palabras
                
                // Contar frecuencia de cada palabra
                for (String palabra : palabrasLinea) {
                    String palabraLimpiada = limpiarPalabra(palabra);
                    if (!palabraLimpiada.isEmpty()) {
                        frecuenciaPalabras.put(palabraLimpiada, frecuenciaPalabras.getOrDefault(palabraLimpiada, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Calcular el promedio de palabras por línea
        double promedioPalabrasPorLinea = lineas > 0 ? (double) palabras / lineas : 0;

        // Mostrar resultados
        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres (sin contar los caracteres de fin de línea): " + caracteres);
        System.out.printf("Promedio de palabras por línea: %.2f%n", promedioPalabrasPorLinea);
        mostrarPalabrasFrecuentes(frecuenciaPalabras);
    }

    private static String limpiarPalabra(String palabra) {
        StringBuilder sb = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase(); // Normalizar a minúsculas
    }

    private static void mostrarPalabrasFrecuentes(Map<String, Integer> frecuenciaPalabras) {
        // Encontrar la máxima frecuencia
        int maxFrecuencia = 0;
        for (int frecuencia : frecuenciaPalabras.values()) {
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
            }
        }

        // Mostrar palabras con la frecuencia máxima
        System.out.println("Palabras más frecuentes:");
        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
