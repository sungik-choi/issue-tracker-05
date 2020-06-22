package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;
import com.codesquad.issuetracker.ragdoll.dao.LabelDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.dto.request.LabelRequestDto;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService_Ragdoll {

    private final LabelDao_Ragdoll labelDaoRagdoll;

    public LabelService_Ragdoll(LabelDao_Ragdoll labelDaoRagdoll) {
        this.labelDaoRagdoll = labelDaoRagdoll;
    }

    public List<LabelDetails> findAttachedLabelsByIssueId(Long issueId) {
        return labelDaoRagdoll.findAttachedLabelsByIssueId(issueId);
    }

    public LabelInformation findAllLabels() {
        List<Label> labels = labelDaoRagdoll.findAllLabels();
        List<LabelDetails> labelsForDetails = labels.stream()
                                                    .map(label -> new LabelDetails.Builder()
                                                                                  .id(label.getId())
                                                                                  .name(label.getName())
                                                                                  .description(label.getDescription())
                                                                                  .backgroundColor(label.getBackgroundColor())
                                                                                  .color(label.getColor())
                                                                                  .build()).collect(Collectors.toList());
        return LabelInformation.of(labelsForDetails.size(), labelsForDetails);
    }

    public String updateLabel(Integer labelId, String labelName, String description, String backgroundColor, String color) {
        labelDaoRagdoll.updateLabel(labelId, labelName, description, backgroundColor, color);
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public String createNewLabel(LabelRequestDto labelRequestDto) {
        labelDaoRagdoll.createNewLabel(labelRequestDto.getLabelName(), labelRequestDto.getDescription(),
                                       labelRequestDto.getBackgroundColor(), labelRequestDto.getColor());
        return ResponseMessages.SUCCESSFULLY_CREATED;
    }

    public String deleteLabel(Integer labelId) {
        labelDaoRagdoll.deleteNewLabel(labelId);
        return ResponseMessages.SUCCESSFULLY_DELETED;
    }
}
