package com.codesquad.issuetracker.main.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Milestone {

    private Integer id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    public Milestone() {}

    private Milestone(Integer id, String title, String description, LocalDate dueDate, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public static Milestone create(Integer id, String title, String description, LocalDate dueDate, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        return new Milestone(id, title, description, dueDate, createdDateTime, updatedDateTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public static class Builder {
        private Integer id;
        private String title;
        private String description;
        private LocalDate dueDate;
        private LocalDateTime createdDateTime;
        private LocalDateTime updatedDateTime;

        public Builder() {}

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder createdDateTime(LocalDateTime createdDateTime) {
            this.createdDateTime = createdDateTime;
            return this;
        }

        public Builder updatedDateTime(LocalDateTime updatedDateTime) {
            this.updatedDateTime = updatedDateTime;
            return this;
        }

        public Milestone build() {
            return new Milestone(id, title, description, dueDate, createdDateTime, updatedDateTime);
        }
    }
}
