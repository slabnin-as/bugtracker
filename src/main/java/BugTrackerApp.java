import dao.DAO;
import dao.IssueDAO;
import db.CreateBugtrackerDB;
import model.Issue;
import model.IssueType;
import model.Role;
import model.User;
import dao.UserDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BugTrackerApp {
    public static void main(String[] args) throws SQLException, IOException {
        DAO<User, String> userDAO = new UserDAO();
        DAO<Issue, String> issueDAO = new IssueDAO();

        Issue issue = new Issue(1000L,55555L,"Тест", null,10000, IssueType.BUG);

        User user1 = new User("Anton", "rainbow", "avvgnh", Role.ADMIN);
        User user2 = new User("Ivan", "swarj", "avvgnh", Role.MANAGER);

        CreateBugtrackerDB db = new CreateBugtrackerDB();

        userDAO.create(user1);
        userDAO.create(user2);
        user2.setPassword("big_dick");
        user2.setRole(Role.DEVELOPER);
        userDAO.update(user2);

        issueDAO.create(issue);

        List<User> userList = userDAO.getAll();

        for(User user : userList){
            System.out.println(user.toString());
        }

        Issue testIssue = issueDAO.read("Тест");
        System.out.println(testIssue);
    }
}
