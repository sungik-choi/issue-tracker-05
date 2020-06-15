package com.codesquad.issuetracker.ragdoll.vo.commentVO;


import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;

import java.time.LocalDateTime;

public class CommentDetails {

    private UserSummary commenter;

    private String description;

    private LocalDateTime createdAt;

    public CommentDetails() {}

    private CommentDetails(UserSummary commenter, String description, LocalDateTime createdAt) {
        this.commenter = commenter;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static CommentDetails create(UserSummary commenter, String description, LocalDateTime createdAt) {
        return new CommentDetails(commenter, description, createdAt);
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
