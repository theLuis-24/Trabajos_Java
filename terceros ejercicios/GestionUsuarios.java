import java.sql.*;
import java.util.Scanner;

public class GestionUsuarios {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_usuarios";
    private static final String USER = "tu_usuario"; 
    private static final String PASSWORD = "tu_contraseña"; 

    private static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void agregarUsuario(String nombre, String email) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Usuario agregado: " + nombre);
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
    }

    public static void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado con ID: " + id);
            } else {
                System.out.println("No se encontró usuario con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public static void actualizarUsuario(int id, String nuevoNombre, String nuevoEmail) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoEmail);
            pstmt.setInt(3, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado con ID: " + id);
            } else {
                System.out.println("No se encontró usuario con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public static void mostrarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Usuarios en la base de datos:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar usuarios: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("\nComandos:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Salir");
            System.out.print("Ingrese un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el email: ");
                    String email = scanner.nextLine();
                    agregarUsuario(nombre, email);
                    break;
                case "2":
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    eliminarUsuario(idEliminar);
                    break;
                case "3":
                    System.out.print("Ingrese el ID del usuario a actualizar: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    actualizarUsuario(idActualizar, nuevoNombre, nuevoEmail);
                    break;
                case "4":
                    mostrarUsuarios();
                    break;
                case "5":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intente de nuevo.");
            }
        } while (!comando.equals("5"));

        scanner.close();
    }
}