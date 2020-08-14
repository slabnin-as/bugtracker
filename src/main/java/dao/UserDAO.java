package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void create(User user);

    void read(String login);

    void update(User user);

    void delete(User user);

    List<User> getAll();

    User getById(long id);
}
