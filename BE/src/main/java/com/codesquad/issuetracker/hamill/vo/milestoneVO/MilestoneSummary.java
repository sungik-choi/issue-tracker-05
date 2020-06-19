package com.codesquad.issuetracker.hamill.vo.milestoneVO;

public class MilestoneSummary {

    private Integer id;

    private String title;

    private MilestoneSummary(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public static MilestoneSummary of(Integer id, String title) {
        return new MilestoneSummary(id, title);
    }

    public Integer getId() { return id; }

    public String getTitle() { return title; }
}

