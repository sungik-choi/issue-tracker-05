package com.codesquad.issuetracker.ragdoll.dto;

import java.util.List;

public class UpdateLabelsRequestDto {

    private Long userId;

    private List<Integer> addedLabelsId;

    private List<Integer> deletedLabelsId;

    public UpdateLabelsRequestDto(Long userId, List<Integer> addedLabelsId, List<Integer> deletedLabelsId) {
        this.userId = userId;
        this.addedLabelsId = addedLabelsId;
        this.deletedLabelsId = deletedLabelsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Integer> getAddedLabelsId() {
        return addedLabelsId;
    }

    public void setAddedLabelsId(List<Integer> addedLabelsId) {
        this.addedLabelsId = addedLabelsId;
    }

    public List<Integer> getDeletedLabelsId() {
        return deletedLabelsId;
    }

    public void setDeletedLabelsId(List<Integer> deletedLabelsId) {
        this.deletedLabelsId = deletedLabelsId;
    }
}
