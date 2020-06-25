package com.codesquad.issuetracker.main.vo.UserVO;

public class UserSummary {

    private Long id;

    private String name;

    private String avatarUrl;

    private UserSummary(Long id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public static UserSummary of(Long id, String name, String avatarUrl) {
        return new UserSummary(id, name, avatarUrl);
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
