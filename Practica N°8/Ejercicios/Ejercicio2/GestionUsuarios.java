import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class GestionUsuarios {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_datos";
    private static final String USER = "root"; // Cambia esto por tu usuario
    private static final String PASSWORD = "080100"; // Cambia esto por tu contraseña

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner scanner = new Scanner(System.in);
            GestorUsuarios gestor = new GestorUsuarios();

            gestor.cargarUsuariosDesdeBD(connection);

            int opcion;

            do {
                System.out.println("Selecciona una opción:");
                System.out.println("1. Mostrar usuarios");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea

                if (opcion == 1) {
                    gestor.mostrarUsuarios(scanner);
                }

            } while (opcion != 0);

            connection.close();
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
