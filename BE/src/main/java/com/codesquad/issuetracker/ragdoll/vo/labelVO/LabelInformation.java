package com.codesquad.issuetracker.ragdoll.vo.labelVO;

import java.util.List;
import java.util.Set;

public class LabelInformation {

    private int countOfLabel;

    private List<LabelSummary> labels;

    public LabelInformation() {}

    private LabelInformation(int countOfLabel, List<LabelSummary> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public static LabelInformation create(int countOfLabel, List<LabelSummary> labels) {
        return new LabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public void setCountOfLabel(int countOfLabel) {
        this.countOfLabel = countOfLabel;
    }

    public List<LabelSummary> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelSummary> labels) {
        this.labels = labels;
    }
}
