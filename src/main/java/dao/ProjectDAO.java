package dao;

import db.ConnectDB;
import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements DAO<Project, String> {
    private Connection connection = ConnectDB.getConnection();

    @Override
    public void create(Project project) {
        try (PreparedStatement statement = connection.prepareStatement(SQLProject.INSERT.QUERY)) {
            statement.setString(1, project.getTitle());
            statement.setString(2, project.getDepartment());
            statement.setLong(3, project.getOwner_id());
            statement.setLong(4, project.getAdmin_id());
            statement.setDate(5, java.sql.Date.valueOf(project.getCreateDate()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project read(String title) {
        Project project = null;

        try (PreparedStatement statement = connection.prepareStatement(SQLProject.GET.QUERY)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDepartment(resultSet.getString("department"));
                project.setOwner_id(resultSet.getLong("owner_id"));
                project.setAdmin_id(resultSet.getLong("admin_id"));
                project.setCreateDate(resultSet.getDate("create_date").toLocalDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return project;
    }

    @Override
    public void update(Project project) {
        try (PreparedStatement statement = connection.prepareStatement(SQLProject.UPDATE.QUERY)) {
            statement.setString(1, project.getTitle());
            statement.setString(2, project.getDepartment());
            statement.setLong(3, project.getOwner_id());
            statement.setLong(4, project.getAdmin_id());
            statement.setLong(5, project.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Project project) {
        try (PreparedStatement statement = connection.prepareStatement(SQLProject.DELETE.QUERY)) {
            statement.setLong(1, project.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLProject.GETALL.QUERY);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDepartment(resultSet.getString("department"));
                project.setOwner_id(resultSet.getLong("owner_id"));
                project.setAdmin_id(resultSet.getLong("admin_id"));
                project.setCreateDate(resultSet.getDate("create_date").toLocalDate());

                projectList.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectList;
    }

    private enum SQLProject {
        GET("SELECT * FROM projects WHERE title = ?"),
        INSERT("INSERT INTO projects (id, title, department, owner_id, admin_id, create_date) " +
                "VALUES (default, ?, ?, ?, ?, ?)"),
        DELETE("DELETE FROM projects WHERE id = ?"),
        UPDATE("UPDATE projects SET title = ?, department = ?, owner_id = ?, admin_id = ? WHERE id = ?"),
        GETALL("SELECT * FROM projects");

        String QUERY;

        SQLProject(String QUERY) {
            this.QUERY = QUERY;
        }

    }
}
