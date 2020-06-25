package com.codesquad.issuetracker.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Issue {

    private Long id;

    private String title;

    private LocalDateTime createdDateTime;

    private boolean opened;

    private Long userId;

    private Integer milestoneId;

    private Issue(Long id, String title, LocalDateTime createdDateTime, boolean opened, Long userId, Integer milestoneId) {
        this.id = id;
        this.title = title;
        this.createdDateTime = createdDateTime;
        this.opened = opened;
        this.userId = userId;
        this.milestoneId = milestoneId;
    }

    public static Issue of(Long id, String title, LocalDateTime createdDateTime, boolean opened, Long userId, Integer milestoneId) {
        return new Builder()
                .id(id)
                .title(title)
                .createdDateTime(createdDateTime)
                .opened(opened)
                .userId(userId)
                .milestoneId(milestoneId)
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    @JsonProperty("isOpened")
    public boolean isOpened() {
        return opened;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    private static class Builder {
        private Long id;
        private String title;
        private LocalDateTime createdDateTime;
        private boolean opened;
        private Long userId;
        private Integer milestoneId;

        private Builder() {}

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder title(String title) {
            this.title = title;
            return this;
        }

        private Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        private Builder opened(boolean opened) {
            this.opened = opened;
            return this;
        }

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private Builder milestoneId(Integer milestoneId) {
            this.milestoneId = milestoneId;
            return this;
        }

        private Issue build() {
            return new Issue(id, title, createdDateTime, opened, userId, milestoneId);
        }
    }
}
