package com.codesquad.issuetracker.hamill.dto.response;

import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.hamill.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneInformation;

import java.util.List;

public class IssueDto {

    private IssueDetails issue;

    private CommentInformation commentInfo;

    private LabelInformation labelInfo;

    private MilestoneInformation milestoneInfo;

    private List<UserSummary> users;

    private IssueDto(IssueDetails issue, CommentInformation commentInfo, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> users) {
        this.issue = issue;
        this.commentInfo = commentInfo;
        this.labelInfo = labelInfo;
        this.milestoneInfo = milestoneInfo;
        this.users = users;
    }

    public static IssueDto of(IssueDetails issue, CommentInformation commentInfo, LabelInformation labelInfo, MilestoneInformation milestoneInfo, List<UserSummary> users) {
        return new Builder()
                .issue(issue)
                .commentInfo(commentInfo)
                .labelInfo(labelInfo)
                .milestoneInfo(milestoneInfo)
                .users(users)
                .build();
    }

    public IssueDetails getIssue() {
        return issue;
    }

    public CommentInformation getCommentInfo() {
        return commentInfo;
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
        private IssueDetails issue;
        private CommentInformation commentInfo;
        private LabelInformation labelInfo;
        private MilestoneInformation milestoneInfo;
        private List<UserSummary> users;

        public Builder() {
        }

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

        public Builder users(List<UserSummary> users) {
            this.users = users;
            return this;
        }

        public IssueDto build() {
            return new IssueDto(issue, commentInfo, labelInfo, milestoneInfo, users);
        }
    }
}
