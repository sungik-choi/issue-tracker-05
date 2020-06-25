package com.codesquad.issuetracker.hamill.dto.response;

import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneInformation;

import java.util.List;

public class ListOfIssuesDto {

    private List<IssueDetails> issues;

    private LabelInformation labelInfo;

    private MilestoneInformation milestoneInfo;

    private List<UserSummary> users;

    private ListOfIssuesDto(List<IssueDetails> issues, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> users) {
        this.issues = issues;
        this.labelInfo = labelInfo;
        this.milestoneInfo = milestoneInfo;
        this.users = users;
    }

    public static ListOfIssuesDto of(List<IssueDetails> issues, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> users) {
        return new Builder()
                .issues(issues)
                .labelInfo(labelInfo)
                .milestoneInfo(milestoneInfo)
                .users(users)
                .build();
    }

    public List<IssueDetails> getIssues() {
        return issues;
    }

    public LabelInformation getLabelInfo() {
        return labelInfo;
    }

    public MilestoneInformation getMilestoneInfo() {
        return milestoneInfo;
    }

    public List<UserSummary> getUsers() {
        return users;
    }

    private static class Builder {
        private List<IssueDetails> issues;
        private LabelInformation labelInfo;
        private MilestoneInformation milestoneInfo;
        private List<UserSummary> users;

        public Builder() {
        }

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

        public Builder users(List<UserSummary> users) {
            this.users = users;
            return this;
        }

        public ListOfIssuesDto build() {
            return new ListOfIssuesDto(issues, labelInfo, milestoneInfo, users);
        }
    }
}
