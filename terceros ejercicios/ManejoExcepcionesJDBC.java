import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoExcepcionesJDBC {

    // URL de la base de datos, usuario y contraseña
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "mi_usuario";
    private static final String PASSWORD = "mi_contraseña";

    public static void main(String[] args) {
        ManejoExcepcionesJDBC app = new ManejoExcepcionesJDBC();
        app.conectarYGestionarBaseDeDatos();
    }

    public void conectarYGestionarBaseDeDatos() {
        Connection connection = null;

        try {
            // Establecer conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");

            // Crear tabla
            crearTabla(connection);

            // Insertar datos
            insertarDatos(connection, "Producto1", 100);
            insertarDatos(connection, "Producto2", 200);

            // Consultar datos
            consultarDatos(connection);

        } catch (SQLException e) {
            manejarSQLException(e);
        } finally {
            // Cerrar conexión
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    private void crearTabla(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS productos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), precio DECIMAL(10, 2))";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Tabla 'productos' creada o ya existe.");
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    private void insertarDatos(Connection connection, String nombre, double precio) {
        String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setDouble(2, precio);
            preparedStatement.executeUpdate();
            System.out.println("Producto '" + nombre + "' insertado.");
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    private void consultarDatos(Connection connection) {
        String sql = "SELECT * FROM productos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Productos en la base de datos:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio);
            }
        } catch (SQLException e) {
            manejarSQLException(e);
        }
    }

    private void manejarSQLException(SQLException e) {
        System.out.println("Error de SQL: " + e.getMessage());
        System.out.println("Código de error: " + e.getErrorCode());
        System.out.println("Estado SQL: " + e.getSQLState());
    }
}