package com.codesquad.issuetracker.hamill.vo.milestoneVO;

public class MilestoneSummary {

    private Integer milestoneId;

    private String milestoneTitle;

    private MilestoneSummary(Integer milestoneId, String milestoneTitle) {
        this.milestoneId = milestoneId;
        this.milestoneTitle = milestoneTitle;
    }

    public static MilestoneSummary of(Integer milestoneId, String milestoneTitle) {
        return new MilestoneSummary(milestoneId, milestoneTitle);
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }
}

