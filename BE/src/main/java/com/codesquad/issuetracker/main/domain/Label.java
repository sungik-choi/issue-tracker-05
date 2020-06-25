package com.codesquad.issuetracker.main.domain;

public class Label {

    private Integer id;

    private String name;

    private String description;

    private String backgroundColor;

    private String color;

    private Label(Integer id, String name, String description, String backgroundColor, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static Label of(Integer id, String name, String description, String backgroundColor, String color) {
        return new Builder()
                .id(id)
                .name(name)
                .description(description)
                .backgroundColor(backgroundColor)
                .color(color)
                .build();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
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
        private Integer id;
        private String name;
        private String description;
        private String backgroundColor;
        private String color;

        private Builder() {}

        private Builder id(Integer id) {
            this.id = id;
            return this;
        }

        private Builder name(String name) {
            this.name = name;
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

        private Label build() {
            return new Label(id, name, description, backgroundColor, color);
        }
    }

}
