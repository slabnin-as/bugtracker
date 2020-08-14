import db.CreateBugtrackerDB;
import model.Role;
import model.User;
import services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BugTrackerApp {
    public static void main(String[] args) throws SQLException, IOException {
        User user1 = new User("Anton", "rainbow", "avvgnh", Role.ADMIN);
        User user2 = new User("Ivan", "swarj", "avvgnh", Role.MANAGER);

        CreateBugtrackerDB db = new CreateBugtrackerDB();
        UserService userService = new UserService();
        userService.create(user1);
        userService.create(user2);
        userService.delete(user2);
        

        List<User> userList = userService.getAll();

        for(User user : userList){
            System.out.println(user.toString());
        }
    }
}
