import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hotel_booking";

    private static final String USER = "root";

    private static final String PASSWORD = "Nayana527@";

    public static Connection getConnection() {

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("MySQL Database Connected Successfully!");

            return connection;

        } catch (Exception e) {

            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());

            return null;
        }
    }
}