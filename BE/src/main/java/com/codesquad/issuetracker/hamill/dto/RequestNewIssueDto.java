package com.codesquad.issuetracker.hamill.dto;

public class RequestNewIssueDto {

    private Long userId;

    private String title;

    private String description;

    private RequestNewIssueDto(Long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public static RequestNewIssueDto of(Long userId, String title, String description) {
        return new Builder()
                .userId(userId)
                .title(title)
                .description(description)
                .build();
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private static class Builder {
        private Long userId;
        private String title;
        private String description;

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private Builder title(String title) {
            this.title = title;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private RequestNewIssueDto build() {
            return new RequestNewIssueDto(userId, title, description);
        }
    }
}
