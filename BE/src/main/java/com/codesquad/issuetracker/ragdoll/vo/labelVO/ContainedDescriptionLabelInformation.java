package com.codesquad.issuetracker.main.vo.labelVO;

import java.util.List;

public class ContainedDescriptionLabelInformation {

    private int countOfLabel;

    private List<ContainedDescriptionLabelSummary> labels;

    private ContainedDescriptionLabelInformation(int countOfLabel, List<ContainedDescriptionLabelSummary> labels) {
        this.countOfLabel = countOfLabel;
        this.labels = labels;
    }

    public static ContainedDescriptionLabelInformation of(int countOfLabel, List<ContainedDescriptionLabelSummary> labels) {
        return new ContainedDescriptionLabelInformation(countOfLabel, labels);
    }

    public int getCountOfLabel() {
        return countOfLabel;
    }

    public List<ContainedDescriptionLabelSummary> getLabels() {
        return labels;
    }
}
