import java.util.ArrayList;

public class Pila<E> {
    private ArrayList<E> elementos; // Cambiado a ArrayList
    
    public Pila() {
        elementos = new ArrayList<>();
    }

    public void push(E valorAMeter) {
        elementos.add(valorAMeter); // Añade el elemento
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (elementos.isEmpty()) {
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        }
        return elementos.remove(elementos.size() - 1); // Elimina y devuelve el último
    }

    public boolean contains(E elemento) {
        return elementos.contains(elemento); // Verifica si contiene el elemento
    }

    public int size() {
        return elementos.size(); // Devuelve el número de elementos en la pila
    }

    public E peek() {
        if (elementos.isEmpty()) {
            throw new ExcepcionPilaVacia("Pila vacía, no se puede ver el tope");
        }
        return elementos.get(elementos.size() - 1); // Devuelve el tope
    }

    public boolean esIgual(Pila<E> otraPila) {
        return this.elementos.equals(otraPila.elementos); // Compara ambas pilas
    }
}
