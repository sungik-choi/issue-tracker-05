package com.codesquad.issuetracker.hamill.vo.issueVO;

import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneSummary;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class IssueDetails {

    private Long issueId;

    private String issueTitle;

    private MilestoneSummary milestone;

    private List<LabelSummary> attachedLabels;

    private UserSummary author;

    private List<UserSummary> allocatedAssignees;

    private LocalDateTime createdAt;

    @JsonProperty("isOpened")
    private boolean opened;

    private IssueDetails(Long issueId, String issueTitle, MilestoneSummary milestone, List<LabelSummary> attachedLabels, UserSummary author, List<UserSummary> allocatedAssignees, LocalDateTime createdAt, boolean opened) {
        this.issueId = issueId;
        this.issueTitle = issueTitle;
        this.milestone = milestone;
        this.attachedLabels = attachedLabels;
        this.author = author;
        this.allocatedAssignees = allocatedAssignees;
        this.createdAt = createdAt;
        this.opened = opened;
    }

    public static IssueDetails of(Long issueId, String issueTitle, MilestoneSummary milestone, List<LabelSummary> attachedLabels, UserSummary author, List<UserSummary> allocatedAssignees, LocalDateTime createdAt, boolean opened) {
        return new Builder()
                .issueId(issueId)
                .issueTitle(issueTitle)
                .milestone(milestone)
                .attachedLabels(attachedLabels)
                .author(author)
                .allocatedAssignees(allocatedAssignees)
                .createdAt(createdAt)
                .opened(opened)
                .build();
    }

    public Long getIssueId() {
        return issueId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

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
        private Long issueId;
        private String issueTitle;
        private MilestoneSummary milestone;
        private List<LabelSummary> attachedLabels;
        private UserSummary author;
        private List<UserSummary> allocatedAssignees;
        private LocalDateTime createdAt;
        private boolean opened;

        private Builder issueId(Long issueId) {
            this.issueId = issueId;
            return this;
        }

        private Builder issueTitle(String issueTitle) {
            this.issueTitle = issueTitle;
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
            return new IssueDetails(issueId, issueTitle, milestone, attachedLabels, author, allocatedAssignees, createdAt, opened);
        }
    }
}
