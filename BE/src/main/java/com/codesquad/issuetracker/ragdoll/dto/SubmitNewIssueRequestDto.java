package com.codesquad.issuetracker.ragdoll.dto;

public class SubmitNewIssueRequestDto {

    private Long authorId;

    private String title;

    private String description;

    public SubmitNewIssueRequestDto() {}

    public SubmitNewIssueRequestDto(Long authorId, String title, String description) {
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
