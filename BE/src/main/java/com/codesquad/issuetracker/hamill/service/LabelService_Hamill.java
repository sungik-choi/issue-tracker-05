package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.IssueHasLabelDao_Hamill;
import com.codesquad.issuetracker.hamill.dao.LabelDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Label;
import com.codesquad.issuetracker.hamill.dto.request.NewLabelDto;
import com.codesquad.issuetracker.hamill.vo.labelVO.ContainedDescriptionLabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.ContainedDescriptionLabelSummary;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary.of;

@Service
public class LabelService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(LabelService_Hamill.class);

    private LabelDao_Hamill labelDao_hamill;
    private IssueHasLabelDao_Hamill issueHasLabelDao_hamill;

    public LabelService_Hamill(LabelDao_Hamill labelDao_hamill, IssueHasLabelDao_Hamill issueHasLabelDao_hamill) {
        this.labelDao_hamill = labelDao_hamill;
        this.issueHasLabelDao_hamill = issueHasLabelDao_hamill;
    }

    public LabelInformation findLabelInformation() {
        List<Label> labels = labelDao_hamill.findAllLabels();

        // 함수형 프로그래밍
        List<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> of(label.getId(), label.getName(), label.getBackgroundColor(), label.getColor()))
                                                 .collect(Collectors.toList());

        return LabelInformation.of(labels.size(), labelSummaries);
    }

    public ContainedDescriptionLabelInformation containDescriptionLabelInformation() {
        List<Label> labels = labelDao_hamill.findAllLabels();

        // 함수형 프로그래밍
        List<ContainedDescriptionLabelSummary> labelSummaries = labels.stream()
                                                                      .map(label -> ContainedDescriptionLabelSummary.of(label.getId(), label.getName(), label.getDescription(), label.getBackgroundColor(), label.getColor()))
                                                                      .collect(Collectors.toList());

        return ContainedDescriptionLabelInformation.of(labels.size(), labelSummaries);
    }

    public List<LabelSummary> findLabelSummariesByIssueId(Long issueId) {
        return labelDao_hamill.findLabelSummariesByIssueId(issueId);
    }

    public void create(NewLabelDto newLabelDto) {
        labelDao_hamill.create(newLabelDto);
    }

    public void update(Integer labelId, NewLabelDto newLabelDto) throws Exception {
        // backgroundColor 와 color 의 형태가 hex code 형태이어야 한다
        if (!(newLabelDto.getBackgroundColor().startsWith("#") && newLabelDto.getColor().startsWith("#"))) {
            throw new Exception("backgroundColor, color 를 hex code 형식으로 넣어주세요(예:#ffffff)");
        }
        labelDao_hamill.update(labelId, newLabelDto);
    }

    public void delete(Integer labelId) {
        issueHasLabelDao_hamill.deleteIssueHasLabelByLabelId(labelId);
        labelDao_hamill.delete(labelId);
    }
}
