package com.codesquad.issuetracker.main.vo.issueVO;

import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.main.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.main.vo.milestoneVO.MilestoneSummary;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class IssueDetails {

    private Long id;

    private String title;

    private MilestoneSummary milestone;

    private List<LabelSummary> attachedLabels;

    private UserSummary author;

    private List<UserSummary> allocatedAssignees;

    private LocalDateTime createdAt;

    @JsonProperty("isOpened")
    private boolean opened;

    private IssueDetails(Long id, String title, MilestoneSummary milestone, List<LabelSummary> attachedLabels, UserSummary author, List<UserSummary> allocatedAssignees, LocalDateTime createdAt, boolean opened) {
        this.id = id;
        this.title = title;
        this.milestone = milestone;
        this.attachedLabels = attachedLabels;
        this.author = author;
        this.allocatedAssignees = allocatedAssignees;
        this.createdAt = createdAt;
        this.opened = opened;
    }

    public static IssueDetails of(Long id, String title, MilestoneSummary milestone, List<LabelSummary> attachedLabels, UserSummary author, List<UserSummary> allocatedAssignees, LocalDateTime createdAt, boolean opened) {
        return new Builder()
                .id(id)
                .title(title)
                .milestone(milestone)
                .attachedLabels(attachedLabels)
                .author(author)
                .allocatedAssignees(allocatedAssignees)
                .createdAt(createdAt)
                .opened(opened)
                .build();
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public MilestoneSummary getMilestone() {
        return milestone;
    }

    public List<LabelSummary> getAttachedLabels() {
        return attachedLabels;
    }

    public UserSummary getAuthor() {
        return author;
    }

    public List<UserSummary> getAllocatedAssignees() {
        return allocatedAssignees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("isOpened")
    public boolean isOpened() {
        return opened;
    }

    private static class Builder {
        private Long id;
        private String title;
        private MilestoneSummary milestone;
        private List<LabelSummary> attachedLabels;
        private UserSummary author;
        private List<UserSummary> allocatedAssignees;
        private LocalDateTime createdAt;
        private boolean opened;

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder title(String title) {
            this.title = title;
            return this;
        }

        private Builder milestone(MilestoneSummary milestone) {
            this.milestone = milestone;
            return this;
        }

        private Builder attachedLabels(List<LabelSummary> attachedLabels) {
            this.attachedLabels = attachedLabels;
            return this;
        }

        private Builder author(UserSummary author) {
            this.author = author;
            return this;
        }

        private Builder allocatedAssignees(List<UserSummary> allocatedAssignees) {
            this.allocatedAssignees = allocatedAssignees;
            return this;
        }

        private Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        private Builder opened(boolean opened) {
            this.opened = opened;
            return this;
        }

        private IssueDetails build() {
            return new IssueDetails(id, title, milestone, attachedLabels, author, allocatedAssignees, createdAt, opened);
        }
    }
}
