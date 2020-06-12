package com.codesquad.issuetracker.ragdoll.dto.milestoneVO;

public class MilestoneSummary {

    private Integer milestoneId;

    private String milestoneTitle;

    public MilestoneSummary() {}

    public MilestoneSummary(Integer milestoneId, String milestoneTitle) {
        this.milestoneId = milestoneId;
        this.milestoneTitle = milestoneTitle;
    }

    public static MilestoneSummary create(Integer milestoneId, String milestoneTitle) {
        return new MilestoneSummary(milestoneId, milestoneTitle);
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }

    public void setMilestoneTitle(String milestoneTitle) {
        this.milestoneTitle = milestoneTitle;
    }
}
