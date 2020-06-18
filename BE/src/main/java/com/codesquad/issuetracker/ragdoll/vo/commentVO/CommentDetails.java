package com.codesquad.issuetracker.ragdoll.vo.commentVO;


import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;

import java.time.LocalDateTime;

public class CommentDetails {

    private UserSummary commenter;

    private Long commentId;

    private String description;

    private LocalDateTime createdAt;

    public CommentDetails() {}

    private CommentDetails(UserSummary commenter, Long commentId, String description, LocalDateTime createdAt) {
        this.commenter = commenter;
        this.commentId = commentId;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static CommentDetails of(UserSummary commenter, Long commentId, String description, LocalDateTime createdAt) {
        return new CommentDetails.Builder()
                                 .commenter(commenter)
                                 .commentId(commentId)
                                 .description(description)
                                 .createdAt(createdAt)
                                 .build();
    }

    public UserSummary getCommenter() {
        return commenter;
    }

    public void setCommenter(UserSummary commenter) {
        this.commenter = commenter;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public static class Builder {
        private UserSummary commenter;
        private Long commentId;
        private String description;
        private LocalDateTime createdAt;

        public Builder commenter(UserSummary commenter) {
            this.commenter = commenter;
            return this;
        }

        public Builder commentId(Long commentId) {
            this.commentId = commentId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CommentDetails build() {
            return new CommentDetails(commenter, commentId, description, createdAt);
        }
    }
}
