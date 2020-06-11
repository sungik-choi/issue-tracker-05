package com.codesquad.issuetracker.dto.hamill.label;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LabelDto {
    private long id;
    private String labelName;
    private String hexCode;
}
