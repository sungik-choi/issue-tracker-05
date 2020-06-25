package com.codesquad.issuetracker.ragdoll.vo.commentVO;

import java.time.LocalDateTime;

public class CommentDetails {

    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private Long userId;

    private String name;

    private String avatarUrl;

    private CommentDetails(Long id, String description, LocalDateTime createdAt, Long userId, String name, String avatarUrl) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.userId = userId;
        this.name = name;
        this.avatarUrl = avatarUrl;
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

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public static class Builder {
        private Long id;
        private String description;
        private LocalDateTime createdAt;
        private Long userId;
        private String name;
        private String avatarUrl;

        public Builder id(Long id) {
            this.id = id;
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

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public CommentDetails build() {
            return new CommentDetails(id, description, createdAt, userId, name, avatarUrl);
        }
    }
}
