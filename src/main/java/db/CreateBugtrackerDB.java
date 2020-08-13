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
        Connection db = ConnectDB.getDBConnection();
        Statement stmt = db.createStatement();

        stmt.execute(sql);
    }
}
