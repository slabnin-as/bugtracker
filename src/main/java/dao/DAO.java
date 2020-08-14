package dao;

import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity model);

    Entity read(Key key);

    void update(Entity model);

    void delete(Entity model);

    List<Entity> getAll();
}
