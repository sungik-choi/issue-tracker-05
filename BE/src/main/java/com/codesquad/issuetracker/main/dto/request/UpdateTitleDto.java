package com.codesquad.issuetracker.main.dto.request;

public class UpdateTitleDto {

    private Long userId;

    private String issueTitle;

    private UpdateTitleDto(Long userId, String issueTitle) {
        this.userId = userId;
        this.issueTitle = issueTitle;
    }

    public static UpdateTitleDto of(Long userId, String issueTitle) {
        return new UpdateTitleDto(userId, issueTitle);
    }

    public Long getUserId() {
        return userId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }
}
