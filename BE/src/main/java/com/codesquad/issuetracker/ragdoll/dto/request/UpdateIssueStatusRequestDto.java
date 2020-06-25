package com.codesquad.issuetracker.ragdoll.dto.request;

import java.util.List;

public class UpdateIssueStatusRequestDto {

    private Long userId;

    private List<Long> issueId;

    private boolean opened;

    public UpdateIssueStatusRequestDto(Long userId, List<Long> issueId, boolean opened) {
        this.userId = userId;
        this.issueId = issueId;
        this.opened = opened;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getIssueId() {
        return issueId;
    }

    public void setIssueId(List<Long> issueId) {
        this.issueId = issueId;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
