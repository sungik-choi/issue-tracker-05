package com.codesquad.issuetracker.ragdoll.dto;

import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneDetails;

import java.util.List;

public class ListOfMilestonesDto {

    private int countOfOpenedMilestone;

    private int countOfClosedMilestone;

    private List<MilestoneDetails> milestones;

    private ListOfMilestonesDto(int countOfOpenedMilestone, int countOfClosedMilestone, List<MilestoneDetails> milestones) {
        this.countOfOpenedMilestone = countOfOpenedMilestone;
        this.countOfClosedMilestone = countOfClosedMilestone;
        this.milestones = milestones;
    }

    private ListOfMilestonesDto of(int countOfOpenedMilestone, int countOfClosedMilestone, List<MilestoneDetails> milestones) {
        return new ListOfMilestonesDto.Builder()
                                      .countOfOpenedMilestone(countOfOpenedMilestone)
                                      .countOfClosedMilestone(countOfClosedMilestone)
                                      .milestones(milestones)
                                      .build();
    }

    public int getCountOfOpenedMilestone() {
        return countOfOpenedMilestone;
    }

    public void setCountOfOpenedMilestone(int countOfOpenedMilestone) {
        this.countOfOpenedMilestone = countOfOpenedMilestone;
    }

    public int getCountOfClosedMilestone() {
        return countOfClosedMilestone;
    }

    public void setCountOfClosedMilestone(int countOfClosedMilestone) {
        this.countOfClosedMilestone = countOfClosedMilestone;
    }

    public List<MilestoneDetails> getMilestones() {
        return milestones;
    }

    public void setMilestones(List<MilestoneDetails> milestones) {
        this.milestones = milestones;
    }

    public static class Builder {
        private int countOfOpenedMilestone;
        private int countOfClosedMilestone;
        private List<MilestoneDetails> milestones;

        public Builder countOfOpenedMilestone(int countOfOpenedMilestone) {
            this.countOfOpenedMilestone = countOfOpenedMilestone;
            return this;
        }

        public Builder countOfClosedMilestone(int countOfClosedMilestone) {
            this.countOfClosedMilestone = countOfClosedMilestone;
            return this;
        }

        public Builder milestones(List<MilestoneDetails> milestones) {
            this.milestones = milestones;
            return this;
        }

        public ListOfMilestonesDto build() {
            return new ListOfMilestonesDto(countOfOpenedMilestone, countOfClosedMilestone,milestones);
        }
    }
}
