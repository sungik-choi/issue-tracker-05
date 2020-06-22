package com.codesquad.issuetracker.ragdoll.vo.labelVO;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LabelDetails {

    private Integer id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    private String backgroundColor;

    private String color;

    private LabelDetails(Integer id, String name, String description, String backgroundColor, String color) {
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

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getColor() {
        return color;
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

        public LabelDetails build() {
            return new LabelDetails(id, name, description, backgroundColor, color);
        }
    }
}
