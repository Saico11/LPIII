public class Personaje {
    private String nombre;
    private int nivel;
    private int salud;
    private int fuerza;

    public Personaje(String nombre, int nivel, int salud, int fuerza) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        if (salud > 0) {
            this.salud = salud;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza > 0) {
            this.fuerza = fuerza;
        }
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                ", fuerza=" + fuerza +
                '}';
    }

    public String toFileString() {
        return nombre + "," + nivel + "," + salud + "," + fuerza;
    }
}
