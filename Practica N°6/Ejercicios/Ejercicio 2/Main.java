public class Main {
    public static void main(String[] args) {
       
        Jugador jugador = new Jugador("Héroe", 100, 5);
        Enemigo enemigo = new Enemigo("Goblin", 80, 3, "Bestia");

       
        jugador.getInventario().agregarItem(new Item("Espada", "Arma", "Una espada afilada", 1));
        jugador.getInventario().agregarItem(new Item("Poción de Vida", "Pocion", "Restaura 50 de salud", 2));

        
        CombateController combate = new CombateController(jugador, enemigo);
        combate.iniciarCombate();
    }
}
