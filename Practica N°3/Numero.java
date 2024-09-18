public class Numero {
    private double valor;

    // Método para establecer el valor, lanzando IllegalArgumentException si es negativo
    public void setValor(double valor) throws IllegalArgumentException {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
        this.valor = valor;
    }

    // Método para obtener el valor
    public double getValor() {
        return valor;
    }

    public static void main(String[] args) {
        Numero numero = new Numero();

        try {
            numero.setValor(-5);  // Provocará la excepción
            System.out.println("Valor: " + numero.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
