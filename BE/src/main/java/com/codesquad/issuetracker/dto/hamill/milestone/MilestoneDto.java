package com.codesquad.issuetracker.dto.hamill.milestone;

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
