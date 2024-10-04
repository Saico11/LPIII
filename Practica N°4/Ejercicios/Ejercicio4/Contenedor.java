import java.util.ArrayList;

public class Contenedor<F, S> {
    // Lista para almacenar múltiples objetos de tipo Par<F, S>
    private ArrayList<Par<F, S>> listaDePares;

    // Constructor que inicializa el ArrayList
    public Contenedor() {
        this.listaDePares = new ArrayList<>();
    }

    // Método para agregar un nuevo par al contenedor
    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        listaDePares.add(nuevoPar);
    }

    // Método para obtener un par según su índice
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaDePares.size()) {
            return listaDePares.get(indice);
        }
        return null; // Devuelve null si el índice no es válido
    }

    // Método para obtener la lista completa de pares
    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return listaDePares;
    }

    // Método para mostrar todos los pares
    public void mostrarPares() {
        for (Par<F, S> par : listaDePares) {
            System.out.println(par);
        }
    }
}
