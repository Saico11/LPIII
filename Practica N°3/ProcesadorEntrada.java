import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// Excepción personalizada para vocales
class VocalException extends Exception {
    public VocalException(char c) {
        super("Se detectó una vocal: " + c);
    }
}

// Excepción personalizada para números
class NumeroException extends Exception {
    public NumeroException(char c) {
        super("Se detectó un número: " + c);
    }
}

// Excepción personalizada para espacios en blanco
class BlancoException extends Exception {
    public BlancoException() {
        super("Se detectó un espacio en blanco.");
    }
}

// Excepción personalizada para salida
class SalidaException extends Exception {
    public SalidaException() {
        super("Se ha detectado el carácter de salida. Terminando el programa.");
    }
}

// Clase para leer caracteres desde el teclado
class LeerEntrada {
    private Reader stream;

    public LeerEntrada(InputStream fuente) {
        stream = new InputStreamReader(fuente);
    }

    public char getChar() throws IOException {
        return (char) this.stream.read();
    }
}

// Clase principal que procesa los caracteres leídos y lanza las excepciones
public class ProcesadorEntrada {

    private LeerEntrada leerEntrada;

    public ProcesadorEntrada() {
        this.leerEntrada = new LeerEntrada(System.in);
    }

    // Método para procesar el carácter leído
    public void procesar() throws VocalException, NumeroException, BlancoException, SalidaException, IOException {
        char c = leerEntrada.getChar();

        if (Character.isDigit(c)) {
            throw new NumeroException(c);
        } else if (Character.isWhitespace(c)) {
            if (c == ' ') {
                throw new BlancoException();
            }
        } else if (c == 'x' || c == 'X') {
            throw new SalidaException();
        } else if (esVocal(c)) {
            throw new VocalException(c);
        }
    }

    // Método auxiliar para detectar si un carácter es una vocal
    private boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        ProcesadorEntrada procesador = new ProcesadorEntrada();

        while (true) {
            try {
                System.out.print("Ingrese un carácter: ");
                procesador.procesar();
            } catch (VocalException | NumeroException | BlancoException e) {
                System.out.println(e.getMessage());
            } catch (SalidaException e) {
                System.out.println(e.getMessage());
                break; // Salimos del bucle para terminar el programa
            } catch (IOException e) {
                System.out.println("Error de entrada/salida.");
            }
        }
    }
}
