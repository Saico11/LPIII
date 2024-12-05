// Interfaz Command
interface Comando {
    void ejecutar();
}

// Clase Receptora
class Televisor {
    public void encender() {
        System.out.println("El televisor está encendido.");
    }

    public void apagar() {
        System.out.println("El televisor está apagado.");
    }

    public void cambiarCanal(int canal) {
        System.out.println("Cambiando al canal " + canal);
    }
}

// Comando concreto: Encender
class EncenderComando implements Comando {
    private Televisor televisor;

    public EncenderComando(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {
        televisor.encender();
    }
}

// Comando concreto: Apagar
class ApagarComando implements Comando {
    private Televisor televisor;

    public ApagarComando(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void ejecutar() {
        televisor.apagar();
    }
}

// Comando concreto: Cambiar canal
class CambiarCanalComando implements Comando {
    private Televisor televisor;
    private int canal;

    public CambiarCanalComando(Televisor televisor, int canal) {
        this.televisor = televisor;
        this.canal = canal;
    }

    @Override
    public void ejecutar() {
        televisor.cambiarCanal(canal);
    }
}

// Clase Invocadora
class ControlRemoto {
    private Comando comando;

    public void configurarComando(Comando comando) {
        this.comando = comando;
    }

    public void presionarBoton() {
        comando.ejecutar();
    }
}

// Clase principal
public class MainCommand {
    public static void main(String[] args) {
        Televisor televisor = new Televisor();
        ControlRemoto control = new ControlRemoto();

        Comando encender = new EncenderComando(televisor);
        Comando apagar = new ApagarComando(televisor);
        Comando cambiarCanal = new CambiarCanalComando(televisor, 5);

        control.configurarComando(encender);
        control.presionarBoton();

        control.configurarComando(cambiarCanal);
        control.presionarBoton();

        control.configurarComando(apagar);
        control.presionarBoton();
    }
}
