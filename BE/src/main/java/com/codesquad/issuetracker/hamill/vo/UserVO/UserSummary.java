package com.codesquad.issuetracker.hamill.vo.UserVO;

public class UserSummary {

    private Long userId;

    private String userName;

    private String avatarUrl;

    private UserSummary(Long userId, String userName, String avatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public static UserSummary of(Long userId, String userName, String avatarUrl) {
        return new UserSummary(userId, userName, avatarUrl);
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
