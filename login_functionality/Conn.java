package login_functionality;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the MySQL database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "your_password");

            // Create a statement to interact with the database
            s = c.createStatement();

            // Test if the connection is working by executing a simple query
            System.out.println("Connection successful!");

            // Optionally, execute a query to check for errors
            ResultSet rs = s.executeQuery("SELECT 1"); // A simple query to test connection
            if (rs.next()) {
                System.out.println("Test query successful! Database is connected.");
            }

        } catch (Exception e) {
            // Print any exception or error details
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn(); // Create an instance of the Conn class to test the connection
    }
}
