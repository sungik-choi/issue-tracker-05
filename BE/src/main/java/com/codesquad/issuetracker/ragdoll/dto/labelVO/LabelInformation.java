package com.codesquad.issuetracker.ragdoll.dto.labelVO;

import java.util.List;

public class LabelInformation {

    private int countOfLabel;

    private List<LabelDetails> labels;

    public LabelInformation() {}

    private LabelInformation(int countOfLabel, List<LabelDetails> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public LabelInformation create(int countOfLabel, List<LabelDetails> labels) {
        return new LabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public void setCountOfLabel(int countOfLabel) {
        this.countOfLabel = countOfLabel;
    }

    public List<LabelDetails> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDetails> labels) {
        this.labels = labels;
    }
}
