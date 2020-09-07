package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Project {
    private Long id;
    private String title;
    private String department;
    private Long owner_id;
    private Long admin_id;

    private Map<Long, Issue> backlog;
    private Map<Long, Issue> sprint;

    private LocalDate createDate;

    public Project(String title, String department, Long owner_id, Long admin_id, LocalDate createDate) {
        this.title = title;
        this.department = department;
        this.owner_id = owner_id;
        this.admin_id = admin_id;
        this.createDate = createDate;

        backlog = new HashMap<>();
        sprint = new HashMap<>();
    }

    public Project(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public Map<Long, Issue> getBacklog() {
        return backlog;
    }

    public void setBacklog(Map<Long, Issue> backlog) {
        this.backlog = backlog;
    }

    public Map<Long, Issue> getSprint() {
        return sprint;
    }

    public void setSprint(Map<Long, Issue> sprint) {
        this.sprint = sprint;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
