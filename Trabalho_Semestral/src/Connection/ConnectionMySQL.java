package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/ts?useSSL=false";
    private static String USER = "root";
    private static String PASSWORD = "0000";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // Check if the connection is closed or null before creating a new one
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static boolean verifyConnection() {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null; // Reset connection reference to avoid reuse
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Connection established: " + conn);
            // Optionally, close the connection for testing
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
