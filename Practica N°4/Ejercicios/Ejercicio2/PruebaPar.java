public class PruebaPar {
    public static void main(String[] args) {
        // Crear dos pares
        Par<String, Integer> par1 = new Par<>("Hola", 123);
        Par<String, Integer> par2 = new Par<>("Hola", 123);
        Par<String, Integer> par3 = new Par<>("Adiós", 456);

        // Probar si son iguales
        System.out.println("¿Par1 es igual a Par2? " + par1.esIgual(par2)); // Debe ser true
        System.out.println("¿Par1 es igual a Par3? " + par1.esIgual(par3)); // Debe ser false
    }
}
