public class TemperaturaSemana {
    private int[] temperaturas;

    public TemperaturaSemana() {
        // Inicializar con valores predeterminados (0°C)
        this.temperaturas = new int[7];
    }

    public int[] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperatura(int dia, int temperatura) {
        if (dia >= 0 && dia < 7) {
            temperaturas[dia] = temperatura;
        }
    }

    public int getTemperatura(int dia) {
        if (dia >= 0 && dia < 7) {
            return temperaturas[dia];
        }
        return 0;
    }
}
