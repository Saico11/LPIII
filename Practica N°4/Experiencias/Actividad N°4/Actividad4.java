public class Actividad4 {
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>();
        Pila<Integer> pila2 = new Pila<>();
        Pila<Integer> pila3 = new Pila<>();

        // Añadir elementos a las pilas
        pila1.push(1);
        pila1.push(2);
        pila1.push(3);

        pila2.push(1);
        pila2.push(2);
        pila2.push(3);

        pila3.push(4);
        pila3.push(5);
        pila3.push(6);

        // Comparar las pilas
        System.out.println("Pila 1 es igual a Pila 2: " + pila1.esIgual(pila2)); // true
        System.out.println("Pila 1 es igual a Pila 3: " + pila1.esIgual(pila3)); // false
    }
}
