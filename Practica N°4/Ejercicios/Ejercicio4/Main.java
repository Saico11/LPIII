public class Main {
    public static void main(String[] args) {
      
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        
        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        
        System.out.println("Lista completa de pares:");
        contenedor.mostrarPares();

       
        Par<String, Integer> par = contenedor.obtenerPar(1);
        System.out.println("Par en el índice 1: " + par);

       
        System.out.println("Lista obtenida de todos los pares:");
        System.out.println(contenedor.obtenerTodosLosPares());
    }
}
