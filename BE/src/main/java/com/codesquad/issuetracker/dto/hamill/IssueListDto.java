package com.codesquad.issuetracker.dto.hamill;

import com.codesquad.issuetracker.dto.hamill.info.*;
import com.codesquad.issuetracker.dto.hamill.label.LabelInfoDto;
import com.codesquad.issuetracker.dto.hamill.milestone.MilestoneInfoDto;
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
