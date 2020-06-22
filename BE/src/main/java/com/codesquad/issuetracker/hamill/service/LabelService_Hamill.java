package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.LabelDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Label;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary.of;

@Service
public class LabelService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(LabelService_Hamill.class);

    private LabelDao_Hamill labelDao_hamill;

    public LabelService_Hamill(LabelDao_Hamill labelDao_hamill) {
        this.labelDao_hamill = labelDao_hamill;
    }

    public LabelInformation findLabelInformation() {
        List<Label> labels = labelDao_hamill.findAllLabels();

        // 함수형 프로그래밍
        List<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> of(label.getId(), label.getName(), label.getBackgroundColor(), label.getColor()))
                                                 .collect(Collectors.toList());

        return LabelInformation.of(labels.size(), labelSummaries);
    }

    public List<LabelSummary> findLabelSummariesByIssueId(Long issueId) {
        return labelDao_hamill.findLabelSummariesByIssueId(issueId);
    }
}
