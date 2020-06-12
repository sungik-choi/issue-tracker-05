package com.codesquad.issuetracker.main.domain;

import java.time.LocalDateTime;

public class Comment {

    private Long id;

    private String description;

    private LocalDateTime createdDateTime;

    private Long issueId;

    private Long userId;

    public Comment() {}

    private Comment(Long id, String description, LocalDateTime createdDateTime, Long issueId, Long userId) {
        this.id = id;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.issueId = issueId;
        this.userId = userId;
    }

    public static Comment create(Long id, String description, LocalDateTime createdDateTime, Long issueId, Long userId) {
        return new Comment(id, description, createdDateTime, issueId, userId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static class Builder {
        private Long id;
        private String description;
        private LocalDateTime createdDateTime;
        private Long issueId;
        private Long userId;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        public Builder issueId(Long issueId) {
            this.issueId = issueId;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Comment build() {
            return new Comment(id, description, createdDateTime, issueId, userId);
        }
    }
}
