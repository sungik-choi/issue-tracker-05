package com.codesquad.issuetracker.main.vo.milestoneVO;

import java.util.List;

public class MilestoneInformation {

    private int countOfMilestone;

    private List<MilestoneSummary> milestones;

    private MilestoneInformation(int countOfMilestone, List<MilestoneSummary> milestones) {
        this.countOfMilestone = countOfMilestone;
        this.milestones = milestones;
    }

    public static MilestoneInformation of(int countOfMilestone, List<MilestoneSummary> milestones) {
        return new MilestoneInformation(countOfMilestone, milestones);
    }

    public int getCountOfMilestone() {
        return countOfMilestone;
    }

    public List<MilestoneSummary> getMilestones() {
        return milestones;
    }
}
