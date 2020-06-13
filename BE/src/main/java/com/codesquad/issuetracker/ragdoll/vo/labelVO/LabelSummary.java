package com.codesquad.issuetracker.ragdoll.vo.labelVO;

public class LabelSummary {

    private Integer labelId;

    private String labelName;

    private String hexCode;

    public LabelSummary() {}

    private LabelSummary(Integer labelId, String labelName, String hexCode) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.hexCode = hexCode;
    }

    public static LabelSummary create(Integer labelId, String labelName, String hexCode) {
        return new LabelSummary(labelId, labelName, hexCode);
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
