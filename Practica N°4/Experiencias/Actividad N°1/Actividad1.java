class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}

public class Actividad1 {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices fuera de rango o inválidos.");
        }

        int count = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            count++;
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);

        try {
            System.out.println("\nImprimiendo subarreglo de arregloInteger (índices 1 a 4):");
            int elementosImpresos = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Cantidad de elementos impresos: " + elementosImpresos);

            System.out.println("\nIntentando imprimir subarreglo con índices inválidos:");
            imprimirArreglo(arregloInteger, 5, 10);
        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
    }
}
