package com.codesquad.issuetracker.main.dto.request;

public class NewUserDto {

    private String name;

    private String email;

    private String avatarUrl;

    private NewUserDto(String name, String email, String avatarUrl) {
        this.name = name;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public static NewUserDto of(String name, String email, String avatarUrl) {
        return new NewUserDto(name, email, avatarUrl);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
