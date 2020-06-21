package com.codesquad.issuetracker.main.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestNewIssueDto {
    private Long userId;
    private String title;
    private String description;
}
