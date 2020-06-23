package com.codesquad.issuetracker.hamill.dto.request;

public class NewLabelDto {

    private String title;

    private String description;

    private String backgroundColor;

    private String color;

    private NewLabelDto(String title, String description, String backgroundColor, String color) {
        this.title = title;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static NewLabelDto of(String title, String description, String backgroundColor, String color) {
        return new Builder()
                .title(title)
                .description(description)
                .backgroundColor(backgroundColor)
                .color(color)
                .build();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getColor() {
        return color;
    }

    private static class Builder {
        private String title;
        private String description;
        private String backgroundColor;
        private String color;

        private Builder title(String title) {
            this.title = title;
            return this;
        }

        private Builder description(String description) {
            this.description = description;
            return this;
        }

        private Builder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        private Builder color(String color) {
            this.color = color;
            return this;
        }

        private NewLabelDto build() {
            return new NewLabelDto(title, description, backgroundColor, color);
        }
    }
}
