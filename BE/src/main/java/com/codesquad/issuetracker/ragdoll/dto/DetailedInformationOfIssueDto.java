package com.codesquad.issuetracker.ragdoll.dto;

import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentDetails;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;

import java.util.List;

public class DetailedInformationOfIssueDto {

    private IssueDetails issueDetails;

    private List<CommentDetails> comments;

    private List<LabelSummary> labelInfo;

    private List<MilestoneInformation> milestoneInfo;

    private List<UserSummary> assigneeInfo;

    public DetailedInformationOfIssueDto() {}

    public DetailedInformationOfIssueDto(IssueDetails issueDetails, List<CommentDetails> comments, List<LabelSummary> labelInfo, List<MilestoneInformation> milestoneInfo, List<UserSummary> assigneeInfo) {
        this.issueDetails = issueDetails;
        this.comments = comments;
        this.labelInfo = labelInfo;
        this.milestoneInfo = milestoneInfo;
        this.assigneeInfo = assigneeInfo;
    }

    public IssueDetails getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(IssueDetails issueDetails) {
        this.issueDetails = issueDetails;
    }

    public List<CommentDetails> getComments() {
        return comments;
    }

    public void setComments(List<CommentDetails> comments) {
        this.comments = comments;
    }

    public List<LabelSummary> getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(List<LabelSummary> labelInfo) {
        this.labelInfo = labelInfo;
    }

    public List<MilestoneInformation> getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(List<MilestoneInformation> milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }

    public List<UserSummary> getAssigneeInfo() {
        return assigneeInfo;
    }

    public void setAssigneeInfo(List<UserSummary> assigneeInfo) {
        this.assigneeInfo = assigneeInfo;
    }

    public static class Builder {
        private IssueDetails issueDetails;
        private List<CommentDetails> comments;
        private List<LabelSummary> labelInfo;
        private List<MilestoneInformation> milestoneInfo;
        private List<UserSummary> assigneeInfo;

        public Builder issueDeatils(IssueDetails issueDetails) {
            this.issueDetails = issueDetails;
            return this;
        }

        public Builder comments(List<CommentDetails> comments) {
            this.comments = comments;
            return this;
        }

        public Builder labelInfo(List<LabelSummary> labelInfo) {
            this.labelInfo = labelInfo;
            return this;
        }

        public Builder milestoneInfo(List<MilestoneInformation> milestoneInfo) {
            this.milestoneInfo = milestoneInfo;
            return this;
        }

        public Builder assigneesInfo(List<UserSummary> assigneesInfo) {
            this.assigneeInfo = assigneesInfo;
            return this;
        }

        public DetailedInformationOfIssueDto build() {
            return new DetailedInformationOfIssueDto(issueDetails, comments, labelInfo, milestoneInfo, assigneeInfo);
        }
    }
}
