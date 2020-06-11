package com.codesquad.issuetracker.dto.hamill;

import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
import com.codesquad.issuetracker.dto.hamill.milestone.MilestoneDto;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestNewIssueDto {
    private Long userId;
    private String title;
    private String description;
    private List<AssigneeDto> allocatedAssignees;
    private List<LabelDto> attachedLabels;
    private MilestoneDto milestone;
}
