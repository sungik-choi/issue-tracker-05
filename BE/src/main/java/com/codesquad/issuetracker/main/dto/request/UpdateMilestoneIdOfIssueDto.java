package com.codesquad.issuetracker.main.dto.request;

public class UpdateMilestoneIdOfIssueDto {

    private Long userId;

    private Integer milestoneId;

    private UpdateMilestoneIdOfIssueDto(Long userId, Integer milestoneId) {
        this.userId = userId;
        this.milestoneId = milestoneId;
    }

    public static UpdateMilestoneIdOfIssueDto of(Long userId, Integer milestoneId) {
        return new UpdateMilestoneIdOfIssueDto(userId, milestoneId);
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }
}
