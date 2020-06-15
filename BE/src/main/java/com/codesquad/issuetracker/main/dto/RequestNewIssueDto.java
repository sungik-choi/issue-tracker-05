package com.codesquad.issuetracker.main.dto;

import com.codesquad.issuetracker.hamill.dto.AssigneeDto;
import com.codesquad.issuetracker.hamill.dto.label.LabelDto;
import com.codesquad.issuetracker.hamill.dto.milestone.MilestoneDto;
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
