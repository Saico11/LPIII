import java.util.ArrayList;
import java.util.List;

// Interfaz para los observadores
interface Observador {
    void actualizar(String mensaje);
}

// Clase que representa a los usuarios (observadores)
class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}

// Clase que administra las notificaciones (sujeto)
class ServicioNotificaciones {
    private List<Observador> usuarios = new ArrayList<>();

    public void suscribir(Observador usuario) {
        usuarios.add(usuario);
    }

    public void desuscribir(Observador usuario) {
        usuarios.remove(usuario);
    }

    public void notificarUsuarios(String mensaje) {
        for (Observador usuario : usuarios) {
            usuario.actualizar(mensaje);
        }
    }
}

// Clase principal
public class MainObserver {
    public static void main(String[] args) {
        ServicioNotificaciones servicio = new ServicioNotificaciones();

        Usuario usuario1 = new Usuario("Usuario1");
        Usuario usuario2 = new Usuario("Usuario2");

        servicio.suscribir(usuario1);
        servicio.suscribir(usuario2);

        servicio.notificarUsuarios("¡Nueva promoción disponible!");
        servicio.desuscribir(usuario1);
        servicio.notificarUsuarios("¡Actualización de producto!");
    }
}
