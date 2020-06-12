package com.codesquad.issuetracker.main.vo.UserVO;

public class UserSummary {

    private Long userId;

    private String userName;

    private String avatarUrl;

    public UserSummary() {}

    private UserSummary(Long userId, String userName, String avatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public static UserSummary create(Long userId, String userName, String avatarUrl) {
        return new UserSummary(userId, userName, avatarUrl);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
