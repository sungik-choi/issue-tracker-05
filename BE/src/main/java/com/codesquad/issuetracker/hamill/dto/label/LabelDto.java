package com.codesquad.issuetracker.hamill.dto.label;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LabelDto {
    private long labelId;
    private String labelName;
    private String hexCode;
}
