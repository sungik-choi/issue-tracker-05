package com.codesquad.issuetracker.main.vo.labelVO;

public class ContainedDescriptionLabelSummary {

    private Integer id;

    private String name;

    private String description;

    private String backgroundColor;

    private String color;

    private ContainedDescriptionLabelSummary(Integer id, String name, String description, String backgroundColor, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static ContainedDescriptionLabelSummary of(Integer id, String name, String description, String backgroundColor, String color) {
        return new ContainedDescriptionLabelSummary(id, name, description, backgroundColor, color);
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public String getDescription() {
        return description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getColor() {
        return color;
    }
}
