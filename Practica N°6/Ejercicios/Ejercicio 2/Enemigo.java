import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void atacar(Jugador jugador) {
        Random random = new Random();
        int dano = random.nextInt(nivel * 10);
        jugador.recibirDano(dano);
        System.out.println(nombre + " ataca a " + jugador.getNombre() + " infligiendo " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        salud -= dano;
        System.out.println(nombre + " ha recibido " + dano + " puntos de daño.");
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}

