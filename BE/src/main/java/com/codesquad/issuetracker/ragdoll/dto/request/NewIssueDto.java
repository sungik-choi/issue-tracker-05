package com.codesquad.issuetracker.main.dto.request;

public class NewIssueDto {

    private Long userId;

    private String title;

    private String description;

    private NewIssueDto(Long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public static NewIssueDto of(Long userId, String title, String description) {
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

        private NewIssueDto build() {
            return new NewIssueDto(userId, title, description);
        }
    }
}
