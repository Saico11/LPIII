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

    // Método toString para mostrar el par
    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Par<String, Integer> par = new Par<>("Hola", 123);
        System.out.println(par); // Salida: (Primero: Hola, Segundo: 123)

        par.setPrimero("Adiós");
        par.setSegundo(456);
        System.out.println(par); // Salida: (Primero: Adiós, Segundo: 456)
    }
}
