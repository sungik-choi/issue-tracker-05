package com.codesquad.issuetracker.hamill.dto.request;

import java.util.List;

public class UpdateStateOfIssueDto {

    private Long userId;

    private List<Long> issueId;

    private boolean isOpened;

    private UpdateStateOfIssueDto(Long userId, List<Long> issueId, boolean isOpened) {
        this.userId = userId;
        this.issueId = issueId;
        this.isOpened = isOpened;
    }

    public static UpdateStateOfIssueDto of(Long userId, List<Long> issueId, boolean isOpened) {
        return new UpdateStateOfIssueDto(userId, issueId, isOpened);
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getIssueId() {
        return issueId;
    }

    public boolean isOpened() {
        return isOpened;
    }
}
