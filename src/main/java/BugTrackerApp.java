import dao.*;
import db.CreateBugtrackerDB;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BugTrackerApp {
    public static void main(String[] args) throws SQLException, IOException {
        DAO<User, String> userDAO = new UserDAO();
        DAO<Issue, String> issueDAO = new IssueDAO();
        DAO<Project, String> projectDAO = new ProjectDAO();

        Issue issue = new Issue(1000L,55555L,"Тест", null,10000, IssueType.BUG);

        User user1 = new User("Anton", "apple", "honda2020", Role.ADMIN);
        User user2 = new User("Ivan", "lemon", "nissan2020", Role.MANAGER);

        CreateBugtrackerDB db = new CreateBugtrackerDB();

        userDAO.create(user1);
        userDAO.create(user2);
        user2.setPassword("audi2019");
        user2.setRole(Role.DEVELOPER);
        userDAO.update(user2);

        Project project = new Project("Project1", "Sberbank", userDAO.read("apple").getId(), userDAO.read("lemon").getId());

        projectDAO.create(project);
        issueDAO.create(issue);

        List<User> userList = userDAO.getAll();

        for(User user : userList){
            System.out.println(user.toString());
        }

        Issue testIssue = issueDAO.read("Тест");
        System.out.println(testIssue);

        testIssue.setTitle("После обновления");
        testIssue.setAssignee_id(45987L);
        issueDAO.update(testIssue);

        System.out.println(testIssue);

        Filter filter = new Filter();
        System.out.println(filter.priorityFilter(IssueType.BUG));
    }
}
