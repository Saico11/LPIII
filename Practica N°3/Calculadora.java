// Excepción personalizada para división por cero
class DivisionPorCeroException extends ArithmeticException {
    public DivisionPorCeroException() {
        super("No se puede dividir por cero.");
    }
}

public class Calculadora {
    // Método para sumar
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar
    public double restar(double a, double b) {
        return a - b;
    }

    // Método para multiplicar
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para dividir
    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        try {
            System.out.println("Suma: " + calc.sumar(10, 5));
            System.out.println("Resta: " + calc.restar(10, 5));
            System.out.println("Multiplicación: " + calc.multiplicar(10, 5));
            System.out.println("División: " + calc.dividir(10, 0));  // Provocará la excepción
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento ilegal: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
}
