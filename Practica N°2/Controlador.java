import java.util.*;

public class Controlador {
    private Map<String, Cliente> clientes;
    private Map<String, Habitacion> habitaciones;
    private Map<String, PersonalLimpieza> personalLimpieza;
    private List<Reserva> reservas;
    private NotificadorReserva notificador;

    public Controlador(CanalNotificacion canal) {
        clientes = new HashMap<>();
        habitaciones = new HashMap<>();
        personalLimpieza = new HashMap<>();
        reservas = new ArrayList<>();
        notificador = new NotificadorReserva(canal);

        // Inicialización de habitaciones de ejemplo
        Habitacion h1 = new Habitacion("H001", 100.0, new ArrayList<>());
        Habitacion h2 = new Habitacion("H002", 150.0, new ArrayList<>());
        habitaciones.put(h1.getCodigo(), h1);
        habitaciones.put(h2.getCodigo(), h2);

        // Inicialización de personal de limpieza de ejemplo
        PersonalLimpieza p1 = new PersonalLimpieza("12345678", "Juan Pérez");
        PersonalLimpieza p2 = new PersonalLimpieza("98765432", "Ana Gómez");
        personalLimpieza.put(p1.getDni(), p1);
        personalLimpieza.put(p2.getDni(), p2);
    }

    public void registrarCliente(String dni, String nombre) {
        if (clientes.containsKey(dni)) {
            System.out.println("Cliente con DNI " + dni + " ya registrado.");
        } else {
            clientes.put(dni, new Cliente(dni, nombre));
            System.out.println("Cliente registrado con éxito.");
            notificador.enviarNotificacion("Cliente registrado: " + nombre + " (DNI: " + dni + ")");
        }
    }

    public void registrarReserva(String dniCliente, String codigoHabitacion, Date fechaInicio, Date fechaFin, PoliticaCancelacion politica) {
        Cliente cliente = clientes.get(dniCliente);
        Habitacion habitacion = habitaciones.get(codigoHabitacion);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (habitacion == null) {
            System.out.println("Habitación no encontrada.");
            return;
        }

        if (!habitacion.estaDisponible()) {
            System.out.println("Habitación no disponible.");
            return;
        }

        Reserva reserva = new Reserva(habitacion, cliente, fechaInicio, fechaFin, politica);
        reservas.add(reserva);
        habitacion.agregarReserva(reserva);
        cliente.agregarReserva(reserva);

        System.out.println("Reserva registrada con éxito.");
        notificador.enviarNotificacion("Reserva realizada para cliente: " + cliente.getNombre() + " en habitación: " + habitacion.getCodigo());
    }

    public void consultarHistorialReservas(String dniCliente) {
        Cliente cliente = clientes.get(dniCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        cliente.generarReporteHistorial();
    }

    public void asignarLimpieza(String dniLimpieza, String codigoHabitacion) {
        PersonalLimpieza personal = personalLimpieza.get(dniLimpieza);
        Habitacion habitacion = habitaciones.get(codigoHabitacion);

        if (personal == null) {
            System.out.println("Personal de limpieza no encontrado.");
            return;
        }

        if (habitacion == null) {
            System.out.println("Habitación no encontrada.");
            return;
        }

        habitacion.asignarPersonalLimpieza(personal);
        personal.asignarHabitacion(habitacion);

        System.out.println("Personal de limpieza asignado.");
        notificador.enviarNotificacion("Personal de limpieza " + personal.getDni() + " asignado a habitación " + habitacion.getCodigo());
    }

    public PersonalLimpieza getPersonalLimpieza(String dni) {
        return personalLimpieza.get(dni);
    }
}
