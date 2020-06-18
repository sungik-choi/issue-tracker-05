package com.codesquad.issuetracker.hamill.vo.labelVO;

import java.util.Set;

public class LabelInformation {

    private int countOfLabel;

    private Set<LabelSummary> labels;

    private LabelInformation(int countOfLabel, Set<LabelSummary> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public static LabelInformation of(int countOfLabel, Set<LabelSummary> labels) {
        return new LabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public Set<LabelSummary> getLabels() {
        return labels;
    }
}
