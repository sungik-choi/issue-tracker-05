package com.codesquad.issuetracker.ragdoll.domain;

import java.time.LocalDateTime;

public class Issue {

    private Long id;

    private String title;

    private LocalDateTime createdDateTime;

    private boolean opened;

    private Long userId;

    private Integer milestoneId;

    public Issue() {}

    private Issue(Long id, String title, LocalDateTime createdDateTime, boolean opened, Long userId, Integer milestoneId) {
        this.id = id;
        this.title = title;
        this.createdDateTime = createdDateTime;
        this.opened = opened;
        this.userId = userId;
        this.milestoneId = milestoneId;
    }

    public static Issue create(Long id, String title, LocalDateTime createdDateTime, boolean opened, Long userId, Integer milestoneId) {
        return new Issue(id, title, createdDateTime, opened, userId, milestoneId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    public static class Builder {
        private Long id;
        private String title;
        private LocalDateTime createdDateTime;
        private boolean opened;
        private Long userId;
        private Integer milestoneId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        public Builder opened(boolean opened) {
            this.opened = opened;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder milestoneId(Integer milestoneId) {
            this.milestoneId = milestoneId;
            return this;
        }

        public Issue build() {
            return new Issue(id, title, createdDateTime, opened, userId, milestoneId);
        }
    }
}
