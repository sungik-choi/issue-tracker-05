package com.codesquad.issuetracker.ragdoll.vo.milestoneVO;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MilestoneSummary {

    private Integer id;

    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double progress;

    private MilestoneSummary(Integer id, String title, Double progress) {
        this.id = id;
        this.title = title;
        this.progress = progress;
    }

    public static MilestoneSummary of(Integer id, String title, Double progress) {
        return new MilestoneSummary(id, title, progress);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
