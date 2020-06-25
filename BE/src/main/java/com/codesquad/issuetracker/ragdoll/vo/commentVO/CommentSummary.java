package com.codesquad.issuetracker.main.vo.commentVO;

import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;

import java.time.LocalDateTime;

public class CommentSummary {

    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private UserSummary commenter;

    private CommentSummary(Long id, String description, LocalDateTime createdAt, UserSummary commenter) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.commenter = commenter;
    }

    public static CommentSummary of(Long id, String description, LocalDateTime createdAt, UserSummary commenter) {
        return new Builder()
                .id(id)
                .description(description)
                .createdAt(createdAt)
                .commenter(commenter)
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserSummary getCommenter() {
        return commenter;
    }

    private static class Builder {
        private Long id;
        private String description;
        private LocalDateTime createdAt;
        private UserSummary commenter;

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        private Builder commenter(UserSummary commenter) {
            this.commenter = commenter;
            return this;
        }

        private CommentSummary build() {
            return new CommentSummary(id, description, createdAt, commenter);
        }
    }
}
