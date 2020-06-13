package com.codesquad.issuetracker.ragdoll.vo.issueVO;

import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
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

    public IssueDetails() {}

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

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public MilestoneSummary getMilestone() {
        return milestone;
    }

    public void setMilestone(MilestoneSummary milestone) {
        this.milestone = milestone;
    }

    public List<LabelSummary> getAttachedLabels() {
        return attachedLabels;
    }

    public void setAttachedLabels(List<LabelSummary> attachedLabels) {
        this.attachedLabels = attachedLabels;
    }

    public UserSummary getAuthor() {
        return author;
    }

    public void setAuthor(UserSummary author) {
        this.author = author;
    }

    public List<UserSummary> getAllocatedAssignees() {
        return allocatedAssignees;
    }

    public void setAllocatedAssignees(List<UserSummary> allocatedAssignees) {
        this.allocatedAssignees = allocatedAssignees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public static class Builder {
        private Long issueId;
        private String issueTitle;
        private MilestoneSummary milestone;
        private List<LabelSummary> attachedLabels;
        private UserSummary author;
        private List<UserSummary> allocatedAssignees;
        private LocalDateTime createdAt;
        private boolean opened;

        public Builder issueId(Long issueId) {
            this.issueId = issueId;
            return this;
        }

        public Builder issueTitle(String issueTitle) {
            this.issueTitle = issueTitle;
            return this;
        }

        public Builder milestone(MilestoneSummary milestone) {
            this.milestone = milestone;
            return this;
        }

        public Builder attachedLabels(List<LabelSummary> attachedLabels) {
            this.attachedLabels = attachedLabels;
            return this;
        }

        public Builder author(UserSummary author) {
            this.author = author;
            return this;
        }

        public Builder allocatedAssignees(List<UserSummary> allocatedAssignees) {
            this.allocatedAssignees = allocatedAssignees;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder opened(boolean opened) {
            this.opened = opened;
            return this;
        }

        public IssueDetails build() {
            return new IssueDetails(issueId, issueTitle, milestone, attachedLabels, author, allocatedAssignees, createdAt, opened);
        }
    }
}
