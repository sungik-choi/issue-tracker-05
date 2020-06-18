package com.codesquad.issuetracker.hamill.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Milestone {

    private Integer id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    private Milestone(Integer id, String title, String description, LocalDate dueDate, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public static Milestone of(Integer id, String title, String description, LocalDate dueDate, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        return new Builder()
                .id(id)
                .title(title)
                .description(description)
                .dueDate(dueDate)
                .createdDateTime(createdDateTime)
                .updatedDateTime(updatedDateTime)
                .build();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    private static class Builder {
        private Integer id;
        private String title;
        private String description;
        private LocalDate dueDate;
        private LocalDateTime createdDateTime;
        private LocalDateTime updatedDateTime;

        private Builder() {}

        private Builder id(Integer id) {
            this.id = id;
            return this;
        }

        private Builder title(String title) {
            this.title = title;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        private Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        private Builder updatedDateTime(LocalDateTime updatedDateTime) {
            this.updatedDateTime = updatedDateTime;
            return this;
        }

        private Milestone build() {
            return new Milestone(id, title, description, dueDate, createdDateTime, updatedDateTime);
        }
    }
}
