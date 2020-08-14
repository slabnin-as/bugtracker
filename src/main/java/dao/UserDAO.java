package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);

    User read(String login);

    void update(User user);

    void delete(User user);

    List<User> getAll();
}
