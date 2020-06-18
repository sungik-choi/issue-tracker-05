package com.codesquad.issuetracker.hamill.vo.milestoneVO;

import java.util.Set;

public class MilestoneInformation {

    private int countOfMilestone;

    private Set<MilestoneSummary> milestones;

    private MilestoneInformation(int countOfMilestone, Set<MilestoneSummary> milestones) {
        this.countOfMilestone = countOfMilestone;
        this.milestones = milestones;
    }

    public static MilestoneInformation of(int countOfMilestone, Set<MilestoneSummary> milestones) {
        return new MilestoneInformation(countOfMilestone, milestones);
    }

    public int getCountOfMilestone() {
        return countOfMilestone;
    }

    public Set<MilestoneSummary> getMilestones() {
        return milestones;
    }
}
