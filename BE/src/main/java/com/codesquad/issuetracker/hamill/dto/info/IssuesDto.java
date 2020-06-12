package com.codesquad.issuetracker.hamill.dto.info;

import com.codesquad.issuetracker.hamill.dto.AssigneeDto;
import com.codesquad.issuetracker.hamill.dto.AuthorDto;
import com.codesquad.issuetracker.hamill.dto.label.LabelDto;
import com.codesquad.issuetracker.hamill.dto.milestone.MilestoneDto;
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
