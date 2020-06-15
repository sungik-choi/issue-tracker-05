package com.codesquad.issuetracker.ragdoll.dto;

import java.util.List;

public class UpdateAssigneesRequestDto {

    private Long userId;

    private List<Long> addedAssigneesId;

    private List<Long> deletedAssigneesId;

    public UpdateAssigneesRequestDto(Long userId, List<Long> addedAssigneesId, List<Long> deletedAssigneesId) {
        this.userId = userId;
        this.addedAssigneesId = addedAssigneesId;
        this.deletedAssigneesId = deletedAssigneesId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getAddedAssigneesId() {
        return addedAssigneesId;
    }

    public void setAddedAssigneesId(List<Long> addedAssigneesId) {
        this.addedAssigneesId = addedAssigneesId;
    }

    public List<Long> getDeletedAssigneesId() {
        return deletedAssigneesId;
    }

    public void setDeletedAssigneesId(List<Long> deletedAssigneesId) {
        this.deletedAssigneesId = deletedAssigneesId;
    }
}
