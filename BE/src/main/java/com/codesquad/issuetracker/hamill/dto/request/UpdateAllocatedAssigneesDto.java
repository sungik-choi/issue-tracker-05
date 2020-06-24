package com.codesquad.issuetracker.hamill.dto.request;

public class UpdateAllocatedAssigneesDto {

    private Long userId;

    private Integer milestoneId;

    private UpdateAllocatedAssigneesDto(Long userId, Integer milestoneId) {
        this.userId = userId;
        this.milestoneId = milestoneId;
    }

    public static UpdateAllocatedAssigneesDto of(Long userId, Integer milestoneId) {
        return new UpdateAllocatedAssigneesDto(userId, milestoneId);
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }
}
