package com.codesquad.issuetracker.main.domain;

import java.time.LocalDateTime;

public class Comment {

    private Long id;

    private String description;

    private LocalDateTime createdDateTime;

    private Long issueId;

    private Long userId;

    private Comment(Long id, String description, LocalDateTime createdDateTime, Long issueId, Long userId) {
        this.id = id;
        this.description = description;
        this.createdDateTime = createdDateTime;
        this.issueId = issueId;
        this.userId = userId;
    }

    public static Comment of(Long id, String description, LocalDateTime createdDateTime, Long issueId, Long userId) {
        return new Builder()
                .id(id)
                .description(description)
                .createdDateTime(createdDateTime)
                .issueId(issueId)
                .userId(userId)
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public Long getIssueId() {
        return issueId;
    }

    public Long getUserId() {
        return userId;
    }

    private static class Builder {
        private Long id;
        private String description;
        private LocalDateTime createdDateTime;
        private Long issueId;
        private Long userId;

        private Builder() {}

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        private Builder issueId(Long issueId) {
            this.issueId = issueId;
            return this;
        }

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private Comment build() {
            return new Comment(id, description, createdDateTime, issueId, userId);
        }
    }
}
