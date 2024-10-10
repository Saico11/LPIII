import java.util.ArrayList;

public class Pila<E> {
    private final int tamanio;
    private ArrayList<E> elementos;
    
    public Pila() {
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        elementos = new ArrayList<>(tamanio);
    }

    public void push(E valorAMeter) {
        if (elementos.size() == tamanio)
            throw new ExcepcionPilaLlena(String.format("La Pila está llena, no se puede meter %s", valorAMeter));
        elementos.add(valorAMeter);
    }

    public E pop() {
        if (elementos.isEmpty())
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        return elementos.remove(elementos.size() - 1);
    }

    public boolean contains(E elemento) {  //verifica
        return elementos.contains(elemento);
    }

    public int size() {
        return elementos.size(); //retorna numero de elementos
    }

    public E peek() {
        if (elementos.isEmpty())
            throw new ExcepcionPilaVacia("Pila vacía, no se puede ver el tope");
        return elementos.get(elementos.size() - 1);
    }
}