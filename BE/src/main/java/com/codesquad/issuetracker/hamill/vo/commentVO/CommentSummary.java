package com.codesquad.issuetracker.hamill.vo.commentVO;

import java.time.LocalDateTime;

public class CommentSummary {

    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private Long userId;

    private CommentSummary(Long id, String description, LocalDateTime createdAt, Long userId) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public static CommentSummary of(Long id, String description, LocalDateTime createdAt, Long userId) {
        return new Builder()
                .id(id)
                .description(description)
                .createdAt(createdAt)
                .userId(userId)
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

    public Long getUserId() {
        return userId;
    }

    private static class Builder {
        private Long id;
        private String description;
        private LocalDateTime createdAt;
        private Long userId;

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

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private CommentSummary build() {
            return new CommentSummary(id, description, createdAt, userId);
        }
    }
}
