public class Main {
    // Método genérico estático para imprimir pares
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        // Crear pares con diferentes tipos
        Par<String, Integer> par1 = new Par<>("Hola", 123);
        Par<Double, Boolean> par2 = new Par<>(45.67, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Italo"), 30);

        // Llamar al método imprimirPar con diferentes tipos de pares
        imprimirPar(par1); // Salida: (Primero: Hola, Segundo: 123)
        imprimirPar(par2); // Salida: (Primero: 45.67, Segundo: true)
        imprimirPar(par3); // Salida: (Primero: Persona: Italo, Segundo: 30)
    }
}
