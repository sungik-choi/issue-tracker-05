package com.codesquad.issuetracker.auth;

import com.codesquad.issuetracker.hamill.dto.request.NewUserDto;

public class AuthCredential {

    private String credential;

    private NewUserDto newUserDto;

    private AuthCredential(String credential, NewUserDto newUserDto) {
        this.credential = credential;
        this.newUserDto = newUserDto;
    }

    public static AuthCredential of(String credential, NewUserDto newUserDto) {
        return new AuthCredential(credential, newUserDto);
    }

    public String getCredential() {
        return credential;
    }

    public NewUserDto getNewUserDto() {
        return newUserDto;
    }

    @Override
    public String toString() {
        return "AuthCredential{" +
                "credential='" + credential + '\'' +
                ", newUserDto=" + newUserDto +
                '}';
    }
}
