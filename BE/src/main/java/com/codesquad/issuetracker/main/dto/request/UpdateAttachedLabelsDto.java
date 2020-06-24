package com.codesquad.issuetracker.main.dto.request;

import java.util.List;

public class UpdateAttachedLabelsDto {

    private Long userId;

    private List<Integer> addedLabelsId;

    private List<Integer> deletedLabelsId;

    private UpdateAttachedLabelsDto(Long userId, List<Integer> addedLabelsId, List<Integer> deletedLabelsId) {
        this.userId = userId;
        this.addedLabelsId = addedLabelsId;
        this.deletedLabelsId = deletedLabelsId;
    }

    public static UpdateAttachedLabelsDto of(Long userId, List<Integer> addedLabelsId, List<Integer> deletedLabelsId) {
        return new UpdateAttachedLabelsDto(userId, addedLabelsId, deletedLabelsId);
    }

    public Long getUserId() {
        return userId;
    }

    public List<Integer> getAddedLabelsId() {
        return addedLabelsId;
    }

    public List<Integer> getDeletedLabelsId() {
        return deletedLabelsId;
    }
}
