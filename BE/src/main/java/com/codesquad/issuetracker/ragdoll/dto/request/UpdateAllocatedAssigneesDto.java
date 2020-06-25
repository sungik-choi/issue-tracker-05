package com.codesquad.issuetracker.main.dto.request;

import java.util.List;

public class UpdateAllocatedAssigneesDto {

    private Long userId;

    private List<Integer> addedAssigneeId;

    private List<Integer> deletedAssigneeId;

    private UpdateAllocatedAssigneesDto(Long userId, List<Integer> addedAssigneeId, List<Integer> deletedAssigneeId) {
        this.userId = userId;
        this.addedAssigneeId = addedAssigneeId;
        this.deletedAssigneeId = deletedAssigneeId;
    }

    public static UpdateAllocatedAssigneesDto of(Long userId, List<Integer> addedAssigneeId, List<Integer> deletedAssigneeId) {
        return new UpdateAllocatedAssigneesDto(userId, addedAssigneeId, deletedAssigneeId);
    }

    public Long getUserId() {
        return userId;
    }

    public List<Integer> getAddedAssigneeId() {
        return addedAssigneeId;
    }

    public List<Integer> getDeletedAssigneeId() {
        return deletedAssigneeId;
    }
}
