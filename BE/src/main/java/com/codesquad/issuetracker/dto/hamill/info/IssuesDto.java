package com.codesquad.issuetracker.dto.hamill.info;

import com.codesquad.issuetracker.dto.hamill.AssigneeDto;
import com.codesquad.issuetracker.dto.hamill.AuthorDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
import com.codesquad.issuetracker.dto.hamill.milestone.MilestoneDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class IssuesDto {
    private Long issueId;
    private String issueTitle;
    private Boolean isOpened;
    private LocalDateTime createdDateTime;
    private MilestoneDto milestone;
    private List<LabelDto> attachedLabels;
    private AuthorDto author;
    private List<AssigneeDto> allocatedAssignees;
}
