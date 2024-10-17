import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;

    public CombateController(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public void iniciarCombate() {
        Random random = new Random();
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            System.out.println("\n--- Turno del jugador ---");
            jugador.atacar(enemigo, jugador.getInventario().buscarItem("Espada"));

            if (!enemigo.estaVivo()) {
                System.out.println(enemigo.getNombre() + " ha sido derrotado.");
                break;
            }

            System.out.println("\n--- Turno del enemigo ---");
            enemigo.atacar(jugador);

            if (!jugador.estaVivo()) {
                System.out.println(jugador.getNombre() + " ha sido derrotado.");
                break;
            }
        }
    }
}
