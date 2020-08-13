package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/bugtracker";
    static final String USER = "admin";
    static final String PASS = "sberbank2020";

    private static Connection connection;

    private ConnectDB() {

    }

    public static Connection getDBConnection() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
