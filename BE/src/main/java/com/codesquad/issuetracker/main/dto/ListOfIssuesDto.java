package com.codesquad.issuetracker.main.dto;

import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;

import java.util.List;

public class ListOfIssuesDto {

    private List<IssueDetails> issues;

    private LabelInformation labelInfo;

    private MilestoneInformation milestoneInfo;

    private List<UserSummary> assigneeInfo;

    public ListOfIssuesDto() {}

    private ListOfIssuesDto(List<IssueDetails> issues, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> assigneeInfo) {
        this.issues = issues;
        this.labelInfo = labelInfo;
        this.milestoneInfo = milestoneInfo;
        this.assigneeInfo = assigneeInfo;
    }

    public static ListOfIssuesDto create(List<IssueDetails> issues, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> assigneeInfo) {
        return new ListOfIssuesDto(issues, labelInfo, milestoneInfo, assigneeInfo);
    }

    public List<IssueDetails> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueDetails> issues) {
        this.issues = issues;
    }

    public LabelInformation getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(LabelInformation labelInfo) {
        this.labelInfo = labelInfo;
    }

    public MilestoneInformation getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(MilestoneInformation milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }

    public List<UserSummary> getAssigneeInfo() {
        return assigneeInfo;
    }

    public void setAssigneeInfo(List<UserSummary> assigneeInfo) {
        this.assigneeInfo = assigneeInfo;
    }

    public static class Builder {
        private List<IssueDetails> issues;
        private LabelInformation labelInfo;
        private MilestoneInformation milestoneInfo;
        private List<UserSummary> assigneeInfo;

        public Builder() {}

        public Builder issues(List<IssueDetails> issues) {
            this.issues = issues;
            return this;
        }

        public Builder labelInfo(LabelInformation labelInfo) {
            this.labelInfo = labelInfo;
            return this;
        }

        public Builder milestoneInfo(MilestoneInformation milestoneInfo) {
            this.milestoneInfo = milestoneInfo;
            return this;
        }

        public Builder assigneeInfo(List<UserSummary> assigneeInfo) {
            this.assigneeInfo = assigneeInfo;
            return this;
        }

        public ListOfIssuesDto build() {
            return new ListOfIssuesDto(issues, labelInfo, milestoneInfo, assigneeInfo);
        }
    }
}
