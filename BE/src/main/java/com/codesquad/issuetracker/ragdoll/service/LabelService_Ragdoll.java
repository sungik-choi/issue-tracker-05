package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;
import com.codesquad.issuetracker.ragdoll.dao.LabelDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.dto.LabelRequestDto;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabelService_Ragdoll {

    private final LabelDao_Ragdoll labelDaoRagdoll;

    public LabelService_Ragdoll(LabelDao_Ragdoll labelDaoRagdoll) {
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

    public String updateLabel(Integer labelId, String labelName, String description, String hexCode) {
        labelDaoRagdoll.updateLabel(labelId, labelName, description, hexCode);
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public String createNewLabel(LabelRequestDto labelRequestDto) {
        labelDaoRagdoll.createNewLabel(labelRequestDto.getLabelName(), labelRequestDto.getDescription(), labelRequestDto.getHexCode());
        return ResponseMessages.SUCCESSFULLY_CREATED;
    }

    public String deleteLabel(Integer labelId) {
        labelDaoRagdoll.deleteNewLabel(labelId);
        return ResponseMessages.SUCCESSFULLY_DELETED;
    }
}
