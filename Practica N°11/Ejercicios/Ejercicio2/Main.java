import java.util.ArrayList;
import java.util.List;

// --------- Observer ---------
// Interfaz Observer
interface Observador {
    void actualizar(String mensaje);
}

// Clase que representa a los usuarios
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

// Clase sujeto que notifica a los usuarios
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

// --------- Strategy ---------
// Interfaz para estrategias de descuento
interface EstrategiaDescuento {
    double aplicarDescuento(double precio);
}

// Estrategia: Sin descuento
class SinDescuento implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio;
    }
}

// Estrategia: Descuento fijo del 10%
class DescuentoFijo implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio * 0.9; // 10% de descuento
    }
}

// Estrategia: Descuento acumulado
class DescuentoAcumulado implements EstrategiaDescuento {
    public double aplicarDescuento(double precio) {
        return precio * 0.8; // 20% de descuento
    }
}

// Clase que usa las estrategias
class CalculadoraPrecios {
    private EstrategiaDescuento estrategia;

    public void establecerEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(double precio) {
        return estrategia.aplicarDescuento(precio);
    }
}

// --------- Command ---------
// Interfaz Command
interface Comando {
    void ejecutar();
}

// Comando: Enviar notificación
class EnviarNotificacionComando implements Comando {
    private ServicioNotificaciones servicio;
    private String mensaje;

    public EnviarNotificacionComando(ServicioNotificaciones servicio, String mensaje) {
        this.servicio = servicio;
        this.mensaje = mensaje;
    }

    @Override
    public void ejecutar() {
        servicio.notificarUsuarios(mensaje);
    }
}

// Comando: Calcular precio con descuento
class CalcularPrecioComando implements Comando {
    private CalculadoraPrecios calculadora;
    private double precio;

    public CalcularPrecioComando(CalculadoraPrecios calculadora, double precio) {
        this.calculadora = calculadora;
        this.precio = precio;
    }

    @Override
    public void ejecutar() {
        System.out.println("Precio final: " + calculadora.calcularPrecio(precio));
    }
}

// Clase invocadora
class Controlador {
    private Comando comando;

    public void configurarComando(Comando comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {
        comando.ejecutar();
    }
}

// --------- Main ---------
public class Main {
    public static void main(String[] args) {
        // Configuración inicial
        ServicioNotificaciones servicio = new ServicioNotificaciones();
        CalculadoraPrecios calculadora = new CalculadoraPrecios();
        Controlador controlador = new Controlador();

        // Crear usuarios y suscribirse
        Usuario usuario1 = new Usuario("Usuario1");
        Usuario usuario2 = new Usuario("Usuario2");
        servicio.suscribir(usuario1);
        servicio.suscribir(usuario2);

        // Enviar notificación
        controlador.configurarComando(new EnviarNotificacionComando(servicio, "¡Nueva promoción: 20% de descuento!"));
        controlador.ejecutarComando();

        // Configurar estrategia de descuento
        calculadora.establecerEstrategia(new DescuentoFijo());
        controlador.configurarComando(new CalcularPrecioComando(calculadora, 100.0));
        controlador.ejecutarComando();

        // Cambiar estrategia y recalcular precio
        calculadora.establecerEstrategia(new DescuentoAcumulado());
        controlador.configurarComando(new CalcularPrecioComando(calculadora, 200.0));
        controlador.ejecutarComando();
    }
}
