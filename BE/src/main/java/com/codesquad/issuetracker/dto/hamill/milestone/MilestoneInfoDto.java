package com.codesquad.issuetracker.dto.hamill.milestone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class MilestoneInfoDto {
    private int totalMilestone;
    private List<MilestoneDto> milestones;
}
