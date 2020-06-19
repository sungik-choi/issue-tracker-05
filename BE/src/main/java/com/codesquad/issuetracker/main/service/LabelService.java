package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.LabelDao;
import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabelService {

    private final LabelDao labelDao;

    public LabelService(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        return labelDao.findAttachedLabelsByIssueId(issueId);
    }

    public LabelInformation findAllLabels() {
        List<Label> labels = labelDao.findAllLabels();
        List<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> new LabelSummary.Builder()
                                                                               .id(label.getId())
                                                                               .name(label.getName())
                                                                               .backgroundColor(label.getBackgroundColor())
                                                                               .color(label.getColor())
                                                                               .build()).collect(Collectors.toList());
        return LabelInformation.create(labelSummaries.size(), labelSummaries);
    }
}
