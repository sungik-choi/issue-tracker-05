package com.codesquad.issuetracker.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommonMessage {
    private String statusCode;
    private String message;
}
