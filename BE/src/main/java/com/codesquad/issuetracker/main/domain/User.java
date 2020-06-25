package com.codesquad.issuetracker.main.domain;

import java.time.LocalDateTime;

public class User {

    private Long id;

    private String name;

    private String email;

    private Long githubId;

    private String avatarUrl;

    private LocalDateTime createdDateTime;

    private User(Long id, String name, String email, Long githubId, String avatarUrl, LocalDateTime createdDateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.githubId = githubId;
        this.avatarUrl = avatarUrl;
        this.createdDateTime = createdDateTime;
    }

    public static User of(Long id, String name, String email, Long githubId, String avatarUrl, LocalDateTime createdDateTime) {
        return new Builder()
                .id(id)
                .name(name)
                .email(email)
                .githubId(githubId)
                .avatarUrl(avatarUrl)
                .createdDateTime(createdDateTime)
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getGithubId() {
        return githubId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    private static class Builder {
        private Long id;
        private String name;
        private String email;
        private Long githubId;
        private String avatarUrl;
        private LocalDateTime createdDateTime;

        private Builder() {}

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder email(String email) {
            this.email = email;
            return this;
        }

        private Builder githubId(Long githubId) {
            this.githubId = githubId;
            return this;
        }

        private Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        private Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        private User build() {
            return new User(id, name, email, githubId, avatarUrl, createdDateTime);
        }
    }
}
