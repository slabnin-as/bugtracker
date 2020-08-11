package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/bugtracker";
    static final String USER = "admin";
    static final String PASS = "sberbank2020";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
