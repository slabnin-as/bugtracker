import dao.DAO;
import db.CreateBugtrackerDB;
import model.Role;
import model.User;
import dao.UserDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BugTrackerApp {
    public static void main(String[] args) throws SQLException, IOException {
        DAO<User, String> dao;

        User user1 = new User("Anton", "rainbow", "avvgnh", Role.ADMIN);
        User user2 = new User("Ivan", "swarj", "avvgnh", Role.MANAGER);

        CreateBugtrackerDB db = new CreateBugtrackerDB();

        dao = new UserDAO();
        dao.create(user1);
        dao.create(user2);
        user2.setPassword("big_dick");
        user2.setRole(Role.DEVELOPER);
        dao.update(user2);

        List<User> userList = dao.getAll();

        for(User user : userList){
            System.out.println(user.toString());
        }
    }
}
