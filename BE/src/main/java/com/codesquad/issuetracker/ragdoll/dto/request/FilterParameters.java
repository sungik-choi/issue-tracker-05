package com.codesquad.issuetracker.ragdoll.dto.request;

public class FilterParameters {

    private Boolean open;

    private Long author;

    private Integer label;

    private Integer milestones;

    private Long assignee;

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public Integer getMilestones() {
        return milestones;
    }

    public void setMilestones(Integer milestones) {
        this.milestones = milestones;
    }

    public Long getAssignee() {
        return assignee;
    }

    public void setAssignee(Long assignee) {
        this.assignee = assignee;
    }
}
