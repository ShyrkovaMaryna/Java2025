import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "Mar7301/";

            public static Connection connect() throws SQLException {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            }

            public static void closeConnection(Connection connection) {
                if (connection != null) {
                    try {
                        connection.close();
                        System.out.println("Connection closed successfully.");
                    } catch (SQLException e) {
                        System.out.println("Error while closing connection.");
                        e.printStackTrace();
                    }
                }
            }

            public static void main(String[] args) {
                Connection connection = null;
                try {
                    connection = connect();
                    System.out.println("Connection successful!");
                } catch (SQLException e) {
                    System.out.println("Connection failed!");
                    e.printStackTrace();
                } finally {
                    closeConnection(connection);
                }
            }
        }


