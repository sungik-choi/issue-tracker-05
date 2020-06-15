package com.codesquad.issuetracker.ragdoll.vo.milestoneVO;

public class MilestoneSummary {

    private Integer milestoneId;

    private String milestoneTitle;

    private Double progress;

    public MilestoneSummary() {}

    public MilestoneSummary(Integer milestoneId, String milestoneTitle) {
        this.milestoneId = milestoneId;
        this.milestoneTitle = milestoneTitle;
    }

    public MilestoneSummary(Integer milestoneId, String milestoneTitle, Double progress) {
        this.milestoneId = milestoneId;
        this.milestoneTitle = milestoneTitle;
        this.progress = progress;
    }

    public static MilestoneSummary create(Integer milestoneId, String milestoneTitle) {
        return new MilestoneSummary(milestoneId, milestoneTitle);
    }

    public static MilestoneSummary create(Integer milestoneId, String milestoneTitle, Double progress) {
        return new MilestoneSummary(milestoneId, milestoneTitle, progress);
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

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
