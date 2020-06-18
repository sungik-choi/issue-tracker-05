package com.codesquad.issuetracker.hamill.vo.labelVO;

public class LabelSummary {

    private Integer labelId;

    private String labelName;

    private String backgroundColor;

    private String color;

    private LabelSummary(Integer labelId, String labelName, String backgroundColor, String color) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public static LabelSummary of(Integer labelId, String labelName, String backgroundColor, String color) {
        return new LabelSummary(labelId, labelName, backgroundColor, color);
    }

    public Integer getLabelId() {
        return labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getColor() {
        return color;
    }
}
