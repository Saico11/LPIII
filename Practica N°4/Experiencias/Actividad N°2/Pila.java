import java.util.ArrayList;

public class Pila<E> {
    private final int tamanio; // tamaño máximo de la pila
    private ArrayList<E> elementos; // lista que almacena los elementos
    
    // Constructor por defecto
    public Pila() {
        this(10); // tamaño predeterminado de la pila
    }

    // Constructor que recibe el tamaño
    public Pila(int s) {
        tamanio = s > 0 ? s : 10; // establece el tamaño de la Pila
        elementos = new ArrayList<>(tamanio); // inicializa la lista
    }

    // Método para añadir un elemento a la pila
    public void push(E valorAMeter) {
        if (elementos.size() == tamanio) // si la pila está llena
            throw new ExcepcionPilaLlena(String.format("La Pila está llena, no se puede meter %s", valorAMeter));
        elementos.add(valorAMeter); // añade valorAMeter a la Pila
    }

    // Método para sacar el último elemento o lanza ExcepcionPilaVacia
    public E pop() {
        if (elementos.isEmpty()) // si la pila está vacía
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        return elementos.remove(elementos.size() - 1); // elimina y devuelve el último
    }

    // Método para verificar si un elemento está en la pila
    public boolean contains(E elemento) {
        return elementos.contains(elemento); // Elemento encontrado
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return elementos.size(); // Devuelve el número de elementos en la pila
    }

    // Método para ver el elemento en el tope de la pila
    public E peek() {
        if (elementos.isEmpty()) // si la pila está vacía
            throw new ExcepcionPilaVacia("Pila vacía, no se puede ver el tope");
        return elementos.get(elementos.size() - 1); // devuelve el tope
    }
}
