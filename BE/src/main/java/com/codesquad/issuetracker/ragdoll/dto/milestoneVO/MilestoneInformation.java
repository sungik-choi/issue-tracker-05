package com.codesquad.issuetracker.ragdoll.dto.milestoneVO;

import java.util.List;

public class MilestoneInformation {

    private int countOfMilestone;

    private List<MilestoneSummary> milestones;

    private MilestoneInformation(int countOfMilestone, List<MilestoneSummary> milestones) {
        this.countOfMilestone = countOfMilestone;
        this.milestones = milestones;
    }

    public MilestoneInformation create(int countOfMilestone, List<MilestoneSummary> milestones) {
        return new MilestoneInformation(countOfMilestone, milestones);
    }

    public int getCountOfMilestone() {
        return countOfMilestone;
    }

    public void setCountOfMilestone(int countOfMilestone) {
        this.countOfMilestone = countOfMilestone;
    }

    public List<MilestoneSummary> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<MilestoneSummary> milestones) {
        this.milestones = milestones;
    }
}
