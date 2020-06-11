package com.codesquad.issuetracker.dto.hamill;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AssigneeDto {
    private long userId;
    private String userName;
}
