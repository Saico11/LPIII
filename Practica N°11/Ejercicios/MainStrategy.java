// Interfaz para estrategias de descuento
interface EstrategiaDescuento {
    double aplicarDescuento(double precio);
}

// Estrategia: Sin descuento
class SinDescuento implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio;
    }
}

// Estrategia: Descuento fijo del 10%
class DescuentoFijo implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio * 0.9; // 10% de descuento
    }
}

// Estrategia: Descuento acumulado
class DescuentoAcumulado implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio * 0.8; // 20% de descuento
    }
}

// Clase que usa las estrategias
class CalculadoraPrecios {
    private EstrategiaDescuento estrategia;

    public void establecerEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(double precio) {
        return estrategia.aplicarDescuento(precio);
    }
}

// Clase principal
public class MainStrategy {
    public static void main(String[] args) {
        CalculadoraPrecios calculadora = new CalculadoraPrecios();

        calculadora.establecerEstrategia(new SinDescuento());
        System.out.println("Sin descuento: " + calculadora.calcularPrecio(100));

        calculadora.establecerEstrategia(new DescuentoFijo());
        System.out.println("Con descuento fijo: " + calculadora.calcularPrecio(100));

        calculadora.establecerEstrategia(new DescuentoAcumulado());
        System.out.println("Con descuento acumulado: " + calculadora.calcularPrecio(100));
    }
}
