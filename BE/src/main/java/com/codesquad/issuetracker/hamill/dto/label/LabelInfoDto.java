package com.codesquad.issuetracker.hamill.dto.label;

import com.codesquad.issuetracker.hamill.dto.label.LabelDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class LabelInfoDto {
    private int totalLabels;
    private List<LabelDto> labels;
}
