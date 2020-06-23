package com.codesquad.issuetracker.main.vo.milestoneVO;

public class MilestoneSummary {

    private Integer id;

    private String title;

    private Double progress;

    private MilestoneSummary(Integer id, String title, Double progress) {
        this.id = id;
        this.title = title;
        this.progress = progress;
    }

    public static MilestoneSummary of(Integer id, String title, Double progress) {
        return new MilestoneSummary(id, title, progress);
    }

    public Integer getId() { return id; }

    public String getTitle() { return title; }

    public Double getProgress() {
        return progress;
    }
}

