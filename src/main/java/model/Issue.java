package model;

import java.time.LocalDate;

public class Issue {
    private Long id;
    private Long project_id;
    private Long parent_id;

    private String title;
    private String description;

    private Long reporter_id;
    private Long assignee_id;

    private IssueState state;
    private IssueType type;

    private LocalDate createDate;

    public Issue(Long project_id, Long parent_id, String title, String description, long reporter_id, IssueType type) {
        this.project_id = project_id;
        this.parent_id = parent_id;
        this.title = title;
        this.description = description;
        this.reporter_id = reporter_id;
        this.type = type;

        state = IssueState.OPEN;
        createDate = LocalDate.now();
    }

    public Issue(){

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public Long getParent_id() {
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

    public Long getReporter_id() {
        return reporter_id;
    }

    public void setReporter_id(long reporter_id) {
        this.reporter_id = reporter_id;
    }

    public Long getAssignee_id() {
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", project_id=" + project_id +
                ", parent_id=" + parent_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reporter_id=" + reporter_id +
                ", assignee_id=" + assignee_id +
                ", state=" + state +
                ", type=" + type +
                ", createDate=" + createDate +
                '}';
    }
}
