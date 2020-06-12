package com.codesquad.issuetracker.main.vo.labelVO;

import java.util.Set;

public class LabelInformation {

    private int countOfLabel;

    private Set<LabelSummary> labels;

    public LabelInformation() {}

    private LabelInformation(int countOfLabel, Set<LabelSummary> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public static LabelInformation create(int countOfLabel, Set<LabelSummary> labels) {
        return new LabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public void setCountOfLabel(int countOfLabel) {
        this.countOfLabel = countOfLabel;
    }

    public Set<LabelSummary> getLabels() {
        return labels;
    }

    public void setLabels(Set<LabelSummary> labels) {
        this.labels = labels;
    }
}
