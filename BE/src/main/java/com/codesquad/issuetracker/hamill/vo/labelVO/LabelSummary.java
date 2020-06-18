package com.codesquad.issuetracker.hamill.vo.labelVO;

public class LabelSummary {

    private Integer labelId;

    private String labelName;

    private String hexCode;

    private LabelSummary(Integer labelId, String labelName, String hexCode) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.hexCode = hexCode;
    }

    public static LabelSummary of(Integer labelId, String labelName, String hexCode) {
        return new LabelSummary(labelId, labelName, hexCode);
    }

    public Integer getLabelId() {
        return labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public String getHexCode() {
        return hexCode;
    }
}
