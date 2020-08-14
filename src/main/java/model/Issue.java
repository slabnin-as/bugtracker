package model;

import jdk.internal.net.http.common.ImmutableSSLSession;

import java.time.LocalDateTime;

public class Issue {
    private long id;
    private long project_id;
    private long parent_id;

    private String title;
    private String description;

    private long reporter_id;
    private long assignee_id;

    private IssueState state;
    private IssueType type;

    private LocalDateTime createDate;

    public Issue(long project_id, long parent_id, String title, String description, long reporter_id, IssueState state, IssueType type) {
        this.project_id = project_id;
        this.parent_id = parent_id;
        this.title = title;
        this.description = description;
        this.reporter_id = reporter_id;
        this.state = state;
        this.type = type;
        
        createDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(long reporter_id) {
        this.reporter_id = reporter_id;
    }

    public long getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(long assignee_id) {
        this.assignee_id = assignee_id;
    }

    public IssueState getState() {
        return state;
    }

    public void setState(IssueState state) {
        this.state = state;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
