package com.codesquad.issuetracker.ragdoll.vo.commentVO;

import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;

import java.time.LocalDateTime;

public class CommentDetails {

    private UserSummary commenter;

    private String description;

    private LocalDateTime createdDateTime;

    public CommentDetails() {}

    private CommentDetails(UserSummary commenter, String description, LocalDateTime createdDateTime) {
        this.commenter = commenter;
        this.description = description;
        this.createdDateTime = createdDateTime;
    }

    public static CommentDetails create(UserSummary commenter, String description, LocalDateTime createdDateTime) {
        return new CommentDetails(commenter, description, createdDateTime);
    }

    public UserSummary getCommenter() {
        return commenter;
    }

    public void setCommenter(UserSummary commenter) {
        this.commenter = commenter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
