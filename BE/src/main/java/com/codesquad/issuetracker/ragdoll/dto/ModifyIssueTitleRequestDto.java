package com.codesquad.issuetracker.ragdoll.dto;

public class ModifyIssueTitleRequestDto {
    private Long userId;

    private String issueTitle;

    public ModifyIssueTitleRequestDto() {}

    private ModifyIssueTitleRequestDto(Long userId, String issueTitle) {
        this.userId = userId;
        this.issueTitle = issueTitle;
    }

    public static ModifyIssueTitleRequestDto create(Long userId, String issueTitle) {
        return new ModifyIssueTitleRequestDto(userId, issueTitle);
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
