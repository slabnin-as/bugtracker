import db.CreateBugtrackerDB;

import java.io.IOException;
import java.sql.SQLException;

public class BugTrackerApp {
    public static void main(String[] args) throws SQLException, IOException {

        CreateBugtrackerDB db = new CreateBugtrackerDB();
    }
}
