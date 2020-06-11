package com.codesquad.issuetracker.dto.hamill.info;

import com.codesquad.issuetracker.dto.hamill.AssigneeDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
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
    private String title;
    private Boolean isOpened;
    private String milestoneTitle;
    private List<LabelDto> labels;
    private LocalDateTime createdDateTime;
    private String author;
    private List<AssigneeDto> assignees;
}
