package model;

import java.time.LocalDate;
import java.util.Map;

public class Project {
    private Long id;
    private String title;
    private String department;
    private Long owner_id;
    private Long admin_id;

    private Map<Long,Issue> backlog;
    private Map<Long,Issue> sprint;

    private LocalDate createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
