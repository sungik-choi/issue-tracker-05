package com.codesquad.issuetracker.ragdoll.domain;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String description;
        private String backgroundColor;
        private String color;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Label build() {
            return new Label(id, name, description, backgroundColor, color);
        }
    }
}
