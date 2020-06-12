package com.codesquad.issuetracker.ragdoll.dto.milestoneVO;

import java.util.List;
import java.util.Set;

public class MilestoneInformation {

    private int countOfMilestone;

    private Set<MilestoneSummary> milestones;

    private MilestoneInformation(int countOfMilestone, Set<MilestoneSummary> milestones) {
        this.countOfMilestone = countOfMilestone;
        this.milestones = milestones;
    }

    public static MilestoneInformation create(int countOfMilestone, Set<MilestoneSummary> milestones) {
        return new MilestoneInformation(countOfMilestone, milestones);
    }

    public int getCountOfMilestone() {
        return countOfMilestone;
    }

    public void setCountOfMilestone(int countOfMilestone) {
        this.countOfMilestone = countOfMilestone;
    }

    public Set<MilestoneSummary> getMilestones() {
        return milestones;
    }

    public void setMilestones(Set<MilestoneSummary> milestones) {
        this.milestones = milestones;
    }
}
