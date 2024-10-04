public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    // Métodos para obtener y establecer el primer elemento
    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    // Métodos para obtener y establecer el segundo elemento
    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    // Método para comparar si dos pares son iguales
    public boolean esIgual(Par<F, S> otroPar) {
        if (this.primero.equals(otroPar.getPrimero()) && this.segundo.equals(otroPar.getSegundo())) {
            return true;
        }
        return false;
    }

    // Método toString para mostrar el par
    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}
