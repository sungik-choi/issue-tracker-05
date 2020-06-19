package com.codesquad.issuetracker.ragdoll.vo.userVO;

public class UserSummary {

    private Long id;

    private String name;

    private String avatarUrl;

    public UserSummary() {}

    private UserSummary(Long id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public static UserSummary of(Long id, String name, String avatarUrl) {
        return new UserSummary(id, name, avatarUrl);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
