package dao;

import db.ConnectDB;
import model.Issue;
import model.IssueState;
import model.IssueType;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    private Connection connection = ConnectDB.getConnection();

    public List<Issue> priorityFilter(IssueType type) {
        List<Issue> issueList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLFilter.PRIORITY.QUERY)) {
            statement.setString(1, type.toString());
            ResultSet resultSet = statement.executeQuery();
            issueList = getIssues(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issueList;
    }

    public List<Issue> dateFilter(LocalDateTime date) {
        List<Issue> issueList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLFilter.PRIORITY.QUERY)) {
            statement.setDate(1, java.sql.Date.valueOf(date.toLocalDate()));
            ResultSet resultSet = statement.executeQuery();
            issueList = getIssues(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issueList;
    }

    public List<Issue> titleFilter(String title) {
        List<Issue> issueList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLFilter.PRIORITY.QUERY)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            issueList = getIssues(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issueList;
    }

    public List<Issue> assigneeFilter(User user) {
        List<Issue> issueList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLFilter.PRIORITY.QUERY)) {
            statement.setLong(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            issueList = getIssues(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issueList;
    }

    private List<Issue> getIssues(ResultSet resultSet) throws SQLException {
        List<Issue> issueList = new ArrayList<>();

        while (resultSet.next()) {
            Issue issue = new Issue();
            issue.setId(resultSet.getLong("id"));
            issue.setProject_id(resultSet.getLong("project_id"));
            issue.setParent_id(resultSet.getLong("parent_id"));
            issue.setTitle(resultSet.getString("title"));
            issue.setDescription(resultSet.getString("description"));
            issue.setReporter_id(resultSet.getLong("reporter_id"));
            issue.setAssignee_id(resultSet.getLong("assignee_id"));
            issue.setType(IssueType.valueOf(resultSet.getString("type")));
            issue.setState(IssueState.valueOf(resultSet.getString("state")));
            issue.setCreateDate(resultSet.getDate("create_date").toLocalDate());

            issueList.add(issue);
        }

        return issueList;
    }

    private enum SQLFilter {
        PRIORITY("SELECT * FROM issues WHERE type = ?::issue_type"),
        CREATE_DATE("SELECT * FROM issues WHERE create_date = ?"),
        TITLE("SELECT * FROM issues WHERE title = ?"),
        ASSIGNEE("SELECT * FROM issues WHERE assignee_id = ?"),
        REPORTER("SELECT * FROM issues WHERE reporter_id = ?");

        String QUERY;

        SQLFilter(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
