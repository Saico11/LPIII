import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cargarUsuariosDesdeBD(Connection connection) {
        usuarios.clear(); 
        try {
            String query = "SELECT * FROM usuarios";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                int edad = resultSet.getInt("edad");
                usuarios.add(new Usuario(id, nombre, email, edad));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar los usuarios desde la base de datos: " + e.getMessage());
        }
    }

    public void mostrarUsuarios(Scanner scanner) {
        System.out.println("¿Qué campos deseas mostrar? (id, nombre, email, edad)");
        String campos = scanner.nextLine();

        System.out.println("¿Quieres aplicar alguna condición? (sí/no)");
        String condicion = scanner.nextLine();
        String campoCondicion = null;
        String valorCondicion = null;

        if (condicion.equalsIgnoreCase("sí")) {
            System.out.println("¿Sobre qué campo? (nombre, email, edad)");
            campoCondicion = scanner.nextLine();
            System.out.println("Ingresa el valor que debe cumplir:");
            valorCondicion = scanner.nextLine();
        }

        System.out.println("¿Deseas ordenar los registros? (ascendente/descendente)");
        String orden = scanner.nextLine();
        String campoOrden = null;

        if (orden.equalsIgnoreCase("ascendente") || orden.equalsIgnoreCase("descendente")) {
            System.out.println("¿Sobre qué campo? (id, nombre, email, edad)");
            campoOrden = scanner.nextLine();
        }

        System.out.println("¿Cuántos registros deseas mostrar?");
        int limite = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Usuario> resultados = new ArrayList<>(usuarios);

        // Filtro por condición
        if (condicion.equalsIgnoreCase("sí")) {
            String finalCampoCondicion = campoCondicion; // variable final
            String finalValorCondicion = valorCondicion; // variable final
            resultados.removeIf(usuario -> {
                switch (finalCampoCondicion) {
                    case "nombre":
                        return !usuario.getNombre().equalsIgnoreCase(finalValorCondicion);
                    case "email":
                        return !usuario.getEmail().equalsIgnoreCase(finalValorCondicion);
                    case "edad":
                        return usuario.getEdad() != Integer.parseInt(finalValorCondicion);
                    default:
                        return true;
                }
            });
        }

        // Ordenar registros
        if (campoOrden != null) {
            Comparator<Usuario> comparator = null;
            switch (campoOrden) {
                case "id":
                    comparator = Comparator.comparingInt(Usuario::getId);
                    break;
                case "nombre":
                    comparator = Comparator.comparing(Usuario::getNombre);
                    break;
                case "email":
                    comparator = Comparator.comparing(Usuario::getEmail);
                    break;
                case "edad":
                    comparator = Comparator.comparingInt(Usuario::getEdad);
                    break;
            }

            if (comparator != null) {
                if (orden.equalsIgnoreCase("ascendente")) {
                    resultados.sort(comparator);
                } else {
                    resultados.sort(comparator.reversed());
                }
            }
        }

        // Mostrar resultados
        resultados.stream().limit(limite).forEach(usuario -> {
            StringBuilder sb = new StringBuilder();
            if (campos.contains("id")) sb.append("ID: ").append(usuario.getId()).append(", ");
            if (campos.contains("nombre")) sb.append("Nombre: ").append(usuario.getNombre()).append(", ");
            if (campos.contains("email")) sb.append("Email: ").append(usuario.getEmail()).append(", ");
            if (campos.contains("edad")) sb.append("Edad: ").append(usuario.getEdad());
            System.out.println(sb.toString());
        });
    }
}
