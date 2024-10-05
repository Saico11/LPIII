import java.util.ArrayList;

public class Contenedor<F, S> {
    
    private ArrayList<Par<F, S>> listaDePares;

    
    public Contenedor() {
        this.listaDePares = new ArrayList<>();
    }

   
    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        listaDePares.add(nuevoPar);
    }

    
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaDePares.size()) {
            return listaDePares.get(indice);
        }
        return null; 
    }


    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return listaDePares;
    }


    public void mostrarPares() {
        for (Par<F, S> par : listaDePares) {
            System.out.println(par);
        }
    }
}
