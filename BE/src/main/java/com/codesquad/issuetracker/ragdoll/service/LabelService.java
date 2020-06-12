package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.LabelDao;
import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabelService {

    private LabelDao labelDao;

    public LabelService(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        return labelDao.findAttachedLabelsByIssueId(issueId);
    }

    public LabelInformation findAllLabels() {
        List<Label> labels = labelDao.findAllLabels();
        Set<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> LabelSummary.create(label.getId(), label.getName(), label.getHexCode()))
                                                 .collect(Collectors.toSet());
        return LabelInformation.create(labelSummaries.size(), labelSummaries);
    }
}
