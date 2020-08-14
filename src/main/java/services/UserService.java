package services;

import dao.UserDAO;
import db.ConnectDB;
import model.Role;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {
    Connection connection = ConnectDB.getConnection();

    @Override
    public void create(User user) {
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(String login) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setString(1, user.getLogin());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQLUser.GETALL.QUERY);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    enum SQLUser {
        GET("INSERT"),
        INSERT("INSERT INTO users (id, name, login, password, role) VALUES (default, ?, ?, ?, ?::users_role)"),
        DELETE("DELETE FROM users WHERE login = (?)"),
        UPDATE("UPDATE"),
        GETALL("SELECT * FROM users");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}