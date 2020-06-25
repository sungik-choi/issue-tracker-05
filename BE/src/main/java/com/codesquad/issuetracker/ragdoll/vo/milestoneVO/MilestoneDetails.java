package com.codesquad.issuetracker.ragdoll.vo.milestoneVO;

import java.time.LocalDate;

public class MilestoneDetails {

    private Integer milestoneId;

    private String milestoneTitle;

    private String description;

    private LocalDate dueDate;

    private double progress;

    private int countOfOpenedIssue;

    private int countOfClosedIssue;

    public MilestoneDetails(Integer milestoneId, String milestoneTitle, String description, LocalDate dueDate, double progress, int countOfOpenedIssue, int countOfClosedIssue) {
        this.milestoneId = milestoneId;
        this.milestoneTitle = milestoneTitle;
        this.description = description;
        this.dueDate = dueDate;
        this.progress = progress;
        this.countOfOpenedIssue = countOfOpenedIssue;
        this.countOfClosedIssue = countOfClosedIssue;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getProgress() {
        return progress;
    }

    public int getCountOfOpenedIssue() {
        return countOfOpenedIssue;
    }

    public int getCountOfClosedIssue() {
        return countOfClosedIssue;
    }

    public static class Builder {
        private Integer milestoneId;
        private String milestoneTitle;
        private String description;
        private LocalDate dueDate;
        private double progress;
        private int countOfOpenedIssue;
        private int countOfClosedIssue;

        public Builder milestoneId(Integer milestoneId) {
            this.milestoneId = milestoneId;
            return this;
        }

        public Builder milestoneTitle(String milestoneTitle) {
            this.milestoneTitle = milestoneTitle;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder progress(double progress) {
            this.progress = progress;
            return this;
        }

        public Builder countOfOpenedIssue(int countOfOpenedIssue) {
            this.countOfOpenedIssue = countOfOpenedIssue;
            return this;
        }

        public Builder countOfClosedIssue(int countOfClosedIssue) {
            this.countOfClosedIssue = countOfClosedIssue;
            return this;
        }

        public MilestoneDetails build() {
            return new MilestoneDetails(milestoneId, milestoneTitle, description, dueDate, progress, countOfOpenedIssue, countOfClosedIssue);
        }
    }
}
