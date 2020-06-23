package com.codesquad.issuetracker.main.dto.request;

import java.util.List;

public class AssignAssigneeToIssueDto {

    private Long userId;

    private List<Long> addedAssigneeId;

    private List<Long> deletedAssigneeId;

    private AssignAssigneeToIssueDto(Long userId, List<Long> addedAssigneeId, List<Long> deletedAssigneeId) {
        this.userId = userId;
        this.addedAssigneeId = addedAssigneeId;
        this.deletedAssigneeId = deletedAssigneeId;
    }

    public static AssignAssigneeToIssueDto of(Long userId, List<Long> addedAssigneeId, List<Long> deletedAssigneeId) {
        return new Builder()
                .userId(userId)
                .addedAssigneeId(addedAssigneeId)
                .deletedAssigneeId(deletedAssigneeId)
                .build();
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getAddedAssigneeId() {
        return addedAssigneeId;
    }

    public List<Long> getDeletedAssigneeId() {
        return deletedAssigneeId;
    }

    private static class Builder {
        private Long userId;
        private List<Long> addedAssigneeId;
        private List<Long> deletedAssigneeId;

        private Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        private Builder addedAssigneeId(List<Long> addedAssigneeId) {
            this.addedAssigneeId = addedAssigneeId;
            return this;
        }

        private Builder deletedAssigneeId(List<Long> deletedAssigneeId) {
            this.deletedAssigneeId = deletedAssigneeId;
            return this;
        }

        private AssignAssigneeToIssueDto build() {
            return new AssignAssigneeToIssueDto(userId, addedAssigneeId, deletedAssigneeId);
        }
    }
}
