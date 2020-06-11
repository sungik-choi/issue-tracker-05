package com.codesquad.issuetracker.ragdoll.dto.labelVO;

public class LabelDetails {

    private Integer labelId;

    private String labelName;

    private String hexCode;

    public LabelDetails() {}

    private LabelDetails(Integer labelId, String labelName, String hexCode) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.hexCode = hexCode;
    }

    public static LabelDetails create(Integer labelId, String labelName, String hexCode) {
        return new LabelDetails(labelId, labelName, hexCode);
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
