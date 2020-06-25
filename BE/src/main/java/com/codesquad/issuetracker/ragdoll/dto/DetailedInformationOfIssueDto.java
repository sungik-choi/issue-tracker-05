package com.codesquad.issuetracker.ragdoll.dto;

import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentDetails;
import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;

import java.util.List;

public class DetailedInformationOfIssueDto {

    private IssueDetails issue;

    private CommentInformation commentInfo;

    private LabelInformation labelInfo;

    private MilestoneInformation milestoneInfo;

    private List<UserSummary> assigneeInfo;

    private DetailedInformationOfIssueDto(IssueDetails issue, CommentInformation commentInfo, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> assigneeInfo) {
        this.issue = issue;
        this.commentInfo = commentInfo;
        this.labelInfo = labelInfo;
        this.milestoneInfo = milestoneInfo;
        this.assigneeInfo = assigneeInfo;
    }

    public IssueDetails getIssue() {
        return issue;
    }

    public void setIssue(IssueDetails issue) {
        this.issue = issue;
    }

    public CommentInformation getCommentInfo() {
        return commentInfo;
    }

    public LabelInformation getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(LabelInformation labelInfo) {
        this.labelInfo = labelInfo;
    }

    public MilestoneInformation getMilestoneInfo() { return milestoneInfo; }

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
        private IssueDetails issue;
        private CommentInformation commentInfo;
        private LabelInformation labelInfo;
        private MilestoneInformation milestoneInfo;
        private List<UserSummary> assigneeInfo;

        public Builder issue(IssueDetails issue) {
            this.issue = issue;
            return this;
        }

        public Builder commentInfo(CommentInformation commentInfo) {
            this.commentInfo = commentInfo;
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

        public DetailedInformationOfIssueDto build() {
            return new DetailedInformationOfIssueDto(issue, commentInfo, labelInfo, milestoneInfo, assigneeInfo);
        }
    }
}
