import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestionDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_datos";
    private static final String USER = "root"; 
    private static final String PASSWORD = "080100"; 

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("Selecciona una opción:");
                System.out.println("1. Ingresar usuario");
                System.out.println("2. Borrar usuario");
                System.out.println("3. Actualizar usuario");
                System.out.println("4. Mostrar usuarios");
                System.out.println("0. Salir");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        ingresarUsuario(connection, scanner);
                        break;
                    case 2:
                        borrarUsuario(connection, scanner);
                        break;
                    case 3:
                        actualizarUsuario(connection, scanner);
                        break;
                    case 4:
                        mostrarUsuarios(connection);
                        break;
                }
            } while (option != 0);

            connection.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void ingresarUsuario(Connection connection, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingresa la clave para confirmar: ");
        String clave = scanner.next();

        if (clave.equals("1234")) { 
            try {
                String sql = "INSERT INTO usuarios (nombre, email, edad) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombre);
                statement.setString(2, email);
                statement.setInt(3, edad);
                statement.executeUpdate();
                System.out.println("Usuario ingresado exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al ingresar el usuario: " + e.getMessage());
            }
        } else {
            System.out.println("Clave incorrecta. No se ingresó el usuario.");
        }
    }

    private static void borrarUsuario(Connection connection, Scanner scanner) {
        System.out.print("ID del usuario a borrar: ");
        int id = scanner.nextInt();
        System.out.print("Ingresa la clave para confirmar: ");
        String clave = scanner.next();

        if (clave.equals("1234")) { // Cambia esta clave si es necesario
            try {
                String sql = "DELETE FROM usuarios WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Usuario borrado exitosamente.");
                } else {
                    System.out.println("No se encontró el usuario con ID: " + id);
                }
            } catch (SQLException e) {
                System.err.println("Error al borrar el usuario: " + e.getMessage());
            }
        } else {
            System.out.println("Clave incorrecta. No se borró el usuario.");
        }
    }

    private static void actualizarUsuario(Connection connection, Scanner scanner) {
        System.out.print("ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.next();
        System.out.print("Nuevo email: ");
        String nuevoEmail = scanner.next();
        System.out.print("Nueva edad: ");
        int nuevaEdad = scanner.nextInt();
        System.out.print("Ingresa la clave para confirmar: ");
        String clave = scanner.next();

        if (clave.equals("1234")) { // Cambia esta clave si es necesario
            try {
                String sql = "UPDATE usuarios SET nombre = ?, email = ?, edad = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nuevoNombre);
                statement.setString(2, nuevoEmail);
                statement.setInt(3, nuevaEdad);
                statement.setInt(4, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Usuario actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró el usuario con ID: " + id);
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar el usuario: " + e.getMessage());
            }
        } else {
            System.out.println("Clave incorrecta. No se actualizó el usuario.");
        }
    }

    private static void mostrarUsuarios(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            var resultSet = statement.executeQuery("SELECT * FROM usuarios");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Nombre: " + resultSet.getString("nombre") +
                                   ", Email: " + resultSet.getString("email") +
                                   ", Edad: " + resultSet.getInt("edad"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar usuarios: " + e.getMessage());
        }
    }
}
