package dao;

import model.Issue;

import java.util.List;

public interface IssueDAO {
    void add(Issue issue);

    void update(Issue issue);

    void remove(Issue issue);

    List<Issue> getAll(long projectId);

    Issue getById(long id);
}
