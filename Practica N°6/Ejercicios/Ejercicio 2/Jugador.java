public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    public void atacar(Enemigo enemigo, Item arma) {
        if (arma != null && arma.getTipo().equals("Arma")) {
            enemigo.recibirDano(nivel * 10);
            System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con " + arma.getNombre());
        } else {
            System.out.println(nombre + " no tiene un arma equipada.");
        }
    }

    public void recibirDano(int dano) {
        salud -= dano;
        System.out.println(nombre + " ha recibido " + dano + " puntos de daño.");
    }

    public void usarItem(Item item) {
        item.usar();
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public InventarioModel getInventario() {
        return inventario;
    }
}
