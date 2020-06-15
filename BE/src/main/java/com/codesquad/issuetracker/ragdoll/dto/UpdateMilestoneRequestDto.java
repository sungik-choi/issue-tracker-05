package com.codesquad.issuetracker.ragdoll.dto;

public class UpdateMilestoneRequestDto {

    private Long userId;

    private Integer milestoneId;

    public UpdateMilestoneRequestDto(Long userId, Integer milestoneId) {
        this.userId = userId;
        this.milestoneId = milestoneId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }
}
