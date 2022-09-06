import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {


    private static final String USERNAME = "Arbnor";
    private static final String PASSWORD = "arbnor";
    private static final String CONN = "jdbc:mysql://localhost:8889/Novels?enabledTLSProtocols=TLSv1.2";

    public static void main(String[] args) {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }
}
