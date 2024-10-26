import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos;

    public GestorProductos() {
        productos = new ArrayList<>();
        cargarDatosDesdeBD();
    }

    // Método para cargar los datos desde la base de datos y guardarlos en la lista
    private void cargarDatosDesdeBD() {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM productos")) {

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad")
                );
                productos.add(producto);
            }

            System.out.println("Datos cargados desde la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al cargar los datos desde la base de datos: " + e.getMessage());
        }
    }

    // Método para realizar consultas sobre la lista de productos
    public void consultarProductos(String campos, String condicion, String ordenarPor, boolean descendente, int limite) {
        System.out.println("Resultados de la consulta:");
        productos.stream()
            .filter(producto -> cumpleCondicion(producto, condicion))
            .sorted(getComparator(ordenarPor, descendente))
            .limit(limite)
            .forEach(producto -> mostrarCampos(producto, campos));
    }

    private boolean cumpleCondicion(Producto producto, String condicion) {
        if (condicion.isEmpty()) {
            return true; // Si no hay condición, mostrar todos
        }
        // Lógica simple para evaluar la condición
        String[] partes = condicion.split("=");
        if (partes.length != 2) return false; // Condición inválida
        String campo = partes[0].trim();
        String valor = partes[1].trim();

        switch (campo.toLowerCase()) {
            case "nombre":
                return producto.getNombre().equalsIgnoreCase(valor);
            case "precio":
                return producto.getPrecio() == Double.parseDouble(valor);
            case "cantidad":
                return producto.getCantidad() == Integer.parseInt(valor);
            default:
                return false;
        }
    }

    private Comparator<Producto> getComparator(String campo, boolean descendente) {
        Comparator<Producto> comparator;
        switch (campo.toLowerCase()) {
            case "nombre":
                comparator = Comparator.comparing(Producto::getNombre);
                break;
            case "precio":
                comparator = Comparator.comparingDouble(Producto::getPrecio);
                break;
            case "cantidad":
                comparator = Comparator.comparingInt(Producto::getCantidad);
                break;
            default:
                comparator = Comparator.comparingInt(Producto::getId); // Orden por ID por defecto
                break;
        }
        return descendente ? comparator.reversed() : comparator;
    }

    private void mostrarCampos(Producto producto, String campos) {
        String[] camposArray = campos.split(",");
        for (String campo : camposArray) {
            campo = campo.trim();
            switch (campo.toLowerCase()) {
                case "id":
                    System.out.print("ID: " + producto.getId() + ", ");
                    break;
                case "nombre":
                    System.out.print("Nombre: " + producto.getNombre() + ", ");
                    break;
                case "precio":
                    System.out.print("Precio: " + producto.getPrecio() + ", ");
                    break;
                case "cantidad":
                    System.out.print("Cantidad: " + producto.getCantidad() + ", ");
                    break;
                default:
                    System.out.println("Campo desconocido: " + campo);
            }
        }
        System.out.println();
    }
}
