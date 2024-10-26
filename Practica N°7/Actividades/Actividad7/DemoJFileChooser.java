import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class DemoJFileChooser extends JFrame {
    private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException {
        super("Demo de JFileChooser");

        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida)); // Agrega un JScrollPane para permitir desplazamiento

        analizarRuta(); // Obtiene la ruta del archivo o directorio seleccionado por el usuario
    }

    public void analizarRuta() throws IOException {
        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", ruta.getFileName()));
            builder.append(String.format("%s un directorio", Files.isDirectory(ruta) ? "Es" : "No es"));
            builder.append(String.format("%s una ruta absoluta", ruta.isAbsolute() ? "Es" : "No es"));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta: %s%n", ruta));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));

                // Iterar sobre los archivos del directorio
                try (Stream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                    flujoDirectorio.forEach(p -> builder.append(String.format("%s%n", p)));
                }
            }

            areaSalida.setText(builder.toString()); // Muestra el contenido del StringBuilder en el JTextArea
        } else {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = selectorArchivos.showOpenDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        return selectorArchivos.getSelectedFile().toPath();
    }

    public static void main(String[] args) throws IOException {
        DemoJFileChooser aplicacion = new Demoaplicacion.setSize(400, 400);
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.setVisible(true);
    }
}