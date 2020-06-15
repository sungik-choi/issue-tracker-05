package com.codesquad.issuetracker.ragdoll.dto;

public class ModifyIssueStatusRequestDto {

    private Long userId;

    private boolean opened;

    public ModifyIssueStatusRequestDto(Long userId, boolean opened) {
        this.userId = userId;
        this.opened = opened;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
