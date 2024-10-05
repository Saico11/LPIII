import java.util.ArrayList;

class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String message) {
        super(message);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String message) {
        super(message);
    }
}

public class Actividad2 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        pila.push(1);
        pila.push(2);
        pila.push(3);

        System.out.println("La pila contiene el 2: " + pila.contains(2));
        System.out.println("La pila contiene el 4: " + pila.contains(4));

        System.out.println("Tamaño de la pila: " + pila.size());

        System.out.println("Elemento en el tope: " + pila.peek());

        System.out.println("Elemento sacado: " + pila.pop());
        System.out.println("Tamaño de la pila después de sacar un elemento: " + pila.size());
    }
}
