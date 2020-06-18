package com.codesquad.issuetracker.ragdoll.dto.request;

public class UpdateIssueTitleRequestDto {
    private Long userId;

    private String issueTitle;

    public UpdateIssueTitleRequestDto() {}

    private UpdateIssueTitleRequestDto(Long userId, String issueTitle) {
        this.userId = userId;
        this.issueTitle = issueTitle;
    }

    public static UpdateIssueTitleRequestDto create(Long userId, String issueTitle) {
        return new UpdateIssueTitleRequestDto(userId, issueTitle);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }
}
