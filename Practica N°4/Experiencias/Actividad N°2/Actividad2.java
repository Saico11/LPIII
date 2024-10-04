import java.util.ArrayList;

// Excepción personalizada para pila llena
class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String message) {
        super(message);
    }
}

// Excepción personalizada para pila vacía
class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String message) {
        super(message);
    }
}

// Clase principal
public class Actividad2 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        // Añadir elementos a la pila
        pila.push(1);
        pila.push(2);
        pila.push(3);

        // Comprobar si un elemento está en la pila
        System.out.println("La pila contiene el 2: " + pila.contains(2)); // true
        System.out.println("La pila contiene el 4: " + pila.contains(4)); // false

        // Mostrar el tamaño de la pila
        System.out.println("Tamaño de la pila: " + pila.size()); // 3

        // Ver el elemento en el tope de la pila
        System.out.println("Elemento en el tope: " + pila.peek()); // 3

        // Sacar un elemento
        System.out.println("Elemento sacado: " + pila.pop()); // 3
        System.out.println("Tamaño de la pila después de sacar un elemento: " + pila.size()); // 2
    }
}
