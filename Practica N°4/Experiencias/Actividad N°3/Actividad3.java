// Clase principal
public class Actividad3 {
    // Método genérico que compara dos objetos
    public static <T> boolean esIgualA(T a, T b) {
        return (a == null && b == null) || (a != null && a.equals(b)); // Compara usando equals
    }

    public static void main(String[] args) {
        // Pruebas del método esIgualA con diferentes tipos de datos

        // Comparación con tipos integrados
        System.out.println("Comparando enteros:");
        System.out.println("5 y 5: " + esIgualA(5, 5)); // true
        System.out.println("5 y 10: " + esIgualA(5, 10)); // false

        // Comparación con null
        System.out.println("Comparando con null:");
        System.out.println("null y null: " + esIgualA(null, null)); // true
        System.out.println("null y \"texto\": " + esIgualA(null, "texto")); // false

        // Comparación con Object
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = obj1; // referencia al mismo objeto

        System.out.println("Comparando objetos:");
        System.out.println("obj1 y obj2: " + esIgualA(obj1, obj2)); // false
        System.out.println("obj1 y obj3: " + esIgualA(obj1, obj3)); // true

        // Comparación con Integer
        Integer num1 = 100;
        Integer num2 = 100;

        System.out.println("Comparando Integer:");
        System.out.println("num1 y num2: " + esIgualA(num1, num2)); // true

        // Comparación con String
        String str1 = "Hola";
        String str2 = "Hola";
        String str3 = "Adiós";

        System.out.println("Comparando String:");
        System.out.println("str1 y str2: " + esIgualA(str1, str2)); // true
        System.out.println("str1 y str3: " + esIgualA(str1, str3)); // false
    }
}
