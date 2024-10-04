public class Main {
    public static void main(String[] args) {
        // Crear un contenedor para pares de tipo String, Integer
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        // Agregar varios pares al contenedor
        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        // Mostrar todos los pares almacenados
        System.out.println("Lista completa de pares:");
        contenedor.mostrarPares();

        // Obtener un par específico por índice
        Par<String, Integer> par = contenedor.obtenerPar(1);
        System.out.println("Par en el índice 1: " + par);

        // Obtener todos los pares en forma de lista
        System.out.println("Lista obtenida de todos los pares:");
        System.out.println(contenedor.obtenerTodosLosPares());
    }
}
