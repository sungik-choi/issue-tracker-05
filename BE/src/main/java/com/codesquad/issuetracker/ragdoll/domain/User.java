package com.codesquad.issuetracker.ragdoll.domain;

import java.time.LocalDateTime;

public class User {

    private Long id;

    private String name;

    private String email;

    private Integer githubId;

    private String avatarUrl;

    private LocalDateTime createdDateTime;

    public User () {}

    private User(Long id, String name, String email, Integer githubId, String avatarUrl, LocalDateTime createdDateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.githubId = githubId;
        this.avatarUrl = avatarUrl;
        this.createdDateTime = createdDateTime;
    }

    public static User create(Long id, String name, String email, Integer githubId, String avatarUrl, LocalDateTime createdDateTime) {
        return new User(id, name, email, githubId, avatarUrl, createdDateTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGithubId() {
        return githubId;
    }

    public void setGithubId(Integer githubId) {
        this.githubId = githubId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private Integer githubId;
        private String avatarUrl;
        private LocalDateTime createdDateTime;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder githubId(Integer githubId) {
            this.githubId = githubId;
            return this;
        }

        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        public User build() {
            return new User(id, name, email, githubId, avatarUrl, createdDateTime);
        }
    }
}
