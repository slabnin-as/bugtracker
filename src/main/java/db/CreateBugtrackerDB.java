package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBugtrackerDB {
    public CreateBugtrackerDB() throws IOException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get("src\\main\\java\\db\\createDB.sql")));
        Connection conn = ConnectDB.getConnection();
        Statement stmt = conn.createStatement();

        stmt.execute(sql);
    }
}
