package com.codesquad.issuetracker.hamill.dto.milestone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MilestoneDto {
    private long milestoneId;
    private String milestoneTitle;
}
