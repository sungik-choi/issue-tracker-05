package com.codesquad.issuetracker.ragdoll.domain;

public class Assignee {

    private Integer id;

    private Long issueId;

    private Long userId;

    public Assignee() {}

    private Assignee(Integer id, Long issueId, Long userId) {
        this.id = id;
        this.issueId = issueId;
        this.userId = userId;
    }

    public static Assignee create(Integer id, Long issueId, Long userId) {
        return new Assignee(id, issueId, userId);
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
