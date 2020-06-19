package com.codesquad.issuetracker.ragdoll.vo.labelVO;

public class LabelSummary {

    private Integer id;

    private String name;

    private String backgroundColor;

    private String color;

    public LabelSummary() {}

    private LabelSummary(Integer id, String name, String backgroundColor, String color) {
        this.id = id;
        this.name = name;
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

        public Builder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public LabelSummary build() {
            return new LabelSummary(id, name, backgroundColor, color);
        }
    }
}
