package com.codesquad.issuetracker.hamill.vo.labelVO;

import java.util.List;

public class LabelInformation {

    private int countOfLabel;

    private List<LabelSummary> labels;

    private LabelInformation(int countOfLabel, List<LabelSummary> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public static LabelInformation of(int countOfLabel, List<LabelSummary> labels) {
        return new LabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public List<LabelSummary> getLabels() {
        return labels;
    }
}
