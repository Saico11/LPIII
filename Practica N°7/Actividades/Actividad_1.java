import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Actividad_1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el nombre del archivo o directorio:");
        // Crear objeto Path con base en la entrada del usuario
        Path ruta = Paths.get(sc.nextLine());

        if (Files.exists(ruta)) {
            // Mostrar información de archivo o directorio
            System.out.printf("%s %s existe%n", ruta.getFileName());
            System.out.printf("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es");
            System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es");
            System.out.printf("Fecha de ultima modificación: %s%n", Files.getLastModifiedTime(ruta));
            System.out.printf("Tamaño: %s%n", Files.size(ruta));
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

            if (Files.isDirectory(ruta)) {
                System.out.println("\nContenido del directorio:");
                // Objeto para iterar en el contenido de un directorio
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);

                for (Path p : flujoDirectorio)
                    System.out.println(p);
            }
        } else {
            System.out.printf("%s no existe%n", ruta);
        }
    }
}
