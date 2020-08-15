package dao;

import db.ConnectDB;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IssueDAO implements DAO<Issue, String> {
    private Connection connection = ConnectDB.getConnection();

    @Override
    public void create(Issue issue) {
        try(PreparedStatement statement = connection.prepareStatement(SQLIssue.INSERT.QUERY)){
            statement.setLong(1, issue.getProject_id());
            statement.setString(2, issue.getTitle());
            statement.setLong(3, issue.getReporter_id());
            statement.setString(4, issue.getType().toString());
            statement.setString(5, issue.getState().toString());
            statement.setDate(6, java.sql.Date.valueOf(issue.getCreateDate()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Issue read(String title) {
        Issue issue = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLIssue.GET.QUERY)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                issue = new Issue();
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issue;
    }

    @Override
    public void update(Issue issue) {

    }

    @Override
    public void delete(Issue issue) {

    }

    @Override
    public List<Issue> getAll() {
        return null;
    }

    public List<Issue> getAllProjectIssue(Project project) {
        return null;

    }

    private enum SQLIssue {
        GET("SELECT * FROM issues WHERE title = ?"),
        INSERT("INSERT INTO issues (id, project_id, title, reporter_id, type, state, create_date) " +
                "VALUES (default, ?, ?, ?, ?::issue_type, ?::issue_state, ?)"),
        DELETE(""),
        UPDATE("");

        String QUERY;

        SQLIssue(String QUERY) {
            this.QUERY = QUERY;
        }

    }
}

