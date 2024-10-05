public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    public static void main(String[] args) {
        Par<String, Integer> par = new Par<>("Hola", 123);
        System.out.println(par); 

        par.setPrimero("Adiós");
        par.setSegundo(456);
        System.out.println(par);
    }
}
