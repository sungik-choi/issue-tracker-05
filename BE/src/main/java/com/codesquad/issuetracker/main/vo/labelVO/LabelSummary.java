package com.codesquad.issuetracker.main.vo.labelVO;

public class LabelSummary {

    private Integer id;

    private String name;

    private String backgroundColor;

    private String color;

    private LabelSummary(Integer id, String name, String backgroundColor, String color) {
        this.id = id;
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static LabelSummary of(Integer id, String name, String backgroundColor, String color) {
        return new LabelSummary(id, name, backgroundColor, color);
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getColor() {
        return color;
    }
}
