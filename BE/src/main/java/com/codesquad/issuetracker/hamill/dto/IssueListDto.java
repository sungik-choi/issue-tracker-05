package com.codesquad.issuetracker.hamill.dto;

import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
import com.codesquad.issuetracker.hamill.dto.label.LabelInfoDto;
import com.codesquad.issuetracker.hamill.dto.milestone.MilestoneInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class IssueListDto {
    private LabelInfoDto labelInfo;
    private MilestoneInfoDto milestoneInfo;
    private List<AuthorDto> authorInfo;
    private List<AssigneeDto> assigneeInfo;
    private List<IssuesDto> issues;
}
