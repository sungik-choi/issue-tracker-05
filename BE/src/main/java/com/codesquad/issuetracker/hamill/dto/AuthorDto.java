package com.codesquad.issuetracker.hamill.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AuthorDto {
    private long userId;
    private String userName;
    private String avatarUrl;
}
