import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
        personajes = new ArrayList<>();
        cargarPersonajes();
        cargarPersonajesAleatorios();  // Carga personajes aleatorios al iniciar
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

    private void cargarPersonajesAleatorios() {
        // Agregar personajes aleatorios para demostrar la funcionalidad
        personajes.add(new Personaje("Guerrero", 1, 100, 20));
        personajes.add(new Personaje("Mago", 1, 80, 25));
        personajes.add(new Personaje("Arquero", 1, 90, 15));
        guardarCambios();  // Guardar los personajes aleatorios
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

    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            switch (atributo.toLowerCase()) {
                case "nivel":
                    p.setNivel(nuevoValor);
                    break;
                case "salud":
                    p.setSalud(nuevoValor);
                    break;
                case "fuerza":
                    p.setFuerza(nuevoValor);
                    break;
                default:
                    System.out.println("Atributo no válido.");
                    return;
            }
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

    public void filtrarPersonajesPorAtributo(String atributo) {
        switch (atributo.toLowerCase()) {
            case "nivel":
                personajes.sort(Comparator.comparingInt(Personaje::getNivel));
                break;
            case "salud":
                personajes.sort(Comparator.comparingInt(Personaje::getSalud));
                break;
            case "fuerza":
                personajes.sort(Comparator.comparingInt(Personaje::getFuerza));
                break;
            default:
                System.out.println("Atributo no válido.");
                return;
        }
        mostrarPersonajes();
    }

    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para mostrar estadísticas.");
            return;
        }

        int totalPersonajes = personajes.size();
        double promedioNivel = personajes.stream().mapToInt(Personaje::getNivel).average().orElse(0);
        double promedioSalud = personajes.stream().mapToInt(Personaje::getSalud).average().orElse(0);
        double promedioFuerza = personajes.stream().mapToInt(Personaje::getFuerza).average().orElse(0);

        System.out.println("Estadísticas:");
        System.out.println("Total de personajes: " + totalPersonajes);
        System.out.println("Promedio de nivel: " + promedioNivel);
        System.out.println("Promedio de salud: " + promedioSalud);
        System.out.println("Promedio de fuerza: " + promedioFuerza);
    }

    public void importarPersonajesDesdeArchivo(String archivoImportar) {
        File file = new File(archivoImportar);
        if (!file.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    int nivel = Integer.parseInt(datos[1]);
                    int salud = Integer.parseInt(datos[2]);
                    int fuerza = Integer.parseInt(datos[3]);
                    agregarPersonaje(nombre, nivel, salud, fuerza);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al importar personajes: " + e.getMessage());
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
