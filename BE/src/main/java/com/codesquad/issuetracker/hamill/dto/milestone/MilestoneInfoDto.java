package com.codesquad.issuetracker.hamill.dto.milestone;

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
