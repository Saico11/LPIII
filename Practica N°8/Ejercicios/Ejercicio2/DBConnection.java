import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_nueva_base";
    private static final String USER = "root";  // Coloca tu usuario
    private static final String PASSWORD = "080100";  // Coloca tu contraseña

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver JDBC
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
