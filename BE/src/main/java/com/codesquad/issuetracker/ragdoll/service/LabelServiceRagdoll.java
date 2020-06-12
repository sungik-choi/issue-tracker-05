package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.LabelDaoRagdoll;
import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabelServiceRagdoll {

    private LabelDaoRagdoll labelDaoRagdoll;

    public LabelServiceRagdoll(LabelDaoRagdoll labelDaoRagdoll) {
        this.labelDaoRagdoll = labelDaoRagdoll;
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        return labelDaoRagdoll.findAttachedLabelsByIssueId(issueId);
    }

    public LabelInformation findAllLabels() {
        List<Label> labels = labelDaoRagdoll.findAllLabels();
        Set<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> LabelSummary.create(label.getId(), label.getName(), label.getHexCode()))
                                                 .collect(Collectors.toSet());
        return LabelInformation.create(labelSummaries.size(), labelSummaries);
    }
}
