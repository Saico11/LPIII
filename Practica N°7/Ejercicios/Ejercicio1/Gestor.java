import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
        personajes = new ArrayList<>();
        cargarPersonajes();
    }

    private void cargarPersonajes() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    int nivel = Integer.parseInt(datos[1]);
                    int salud = Integer.parseInt(datos[2]);
                    int fuerza = Integer.parseInt(datos[3]);
                    personajes.add(new Personaje(nombre, nivel, salud, fuerza));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar personajes: " + e.getMessage());
        }
    }

    public void agregarPersonaje(String nombre, int nivel, int salud, int fuerza) {
        if (buscarPersonaje(nombre) != null) {
            System.out.println("El personaje ya existe.");
            return;
        }
        personajes.add(new Personaje(nombre, nivel, salud, fuerza));
        guardarCambios();
    }

    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void modificarPersonaje(String nombre, int nivel, int salud, int fuerza) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            p.setNivel(nivel);
            p.setSalud(salud);
            p.setFuerza(fuerza);
            guardarCambios();
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    public void eliminarPersonaje(String nombre) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            personajes.remove(p);
            guardarCambios();
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes disponibles.");
        } else {
            for (Personaje p : personajes) {
                System.out.println(p);
            }
        }
    }

    private void guardarCambios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                bw.write(p.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar personajes: " + e.getMessage());
        }
    }
}
