public class Main {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola", 123);
        Par<Double, Boolean> par2 = new Par<>(45.67, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Italo"), 30);

        imprimirPar(par1);
        imprimirPar(par2); 
        imprimirPar(par3); 
    }
}
