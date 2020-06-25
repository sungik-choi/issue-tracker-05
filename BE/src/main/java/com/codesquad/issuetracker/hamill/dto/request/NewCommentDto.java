package com.codesquad.issuetracker.hamill.dto.request;

public class NewCommentDto {

    private Long userId;

    private String description;

    private NewCommentDto(Long userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public static NewCommentDto of(Long userId, String description) {
        return new NewCommentDto.Builder()
                .userId(userId)
                .description(description)
                .build();
    }

    public Long getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    private static class Builder {
        private Long userId;
        private String description;

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private NewCommentDto build() {
            return new NewCommentDto(userId, description);
        }
    }
}
