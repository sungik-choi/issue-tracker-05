package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.LabelDao;
import com.codesquad.issuetracker.main.domain.Label;
import com.codesquad.issuetracker.main.dto.request.NewLabelDto;
import com.codesquad.issuetracker.main.vo.labelVO.ContainedDescriptionLabelInformation;
import com.codesquad.issuetracker.main.vo.labelVO.ContainedDescriptionLabelSummary;
import com.codesquad.issuetracker.main.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.main.vo.labelVO.LabelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.codesquad.issuetracker.main.vo.labelVO.LabelSummary.of;

@Service
public class LabelService {

    private static final Logger logger = LoggerFactory.getLogger(LabelService.class);

    private LabelDao labelDao;

    public LabelService(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public LabelInformation findLabelInformation() {
        List<Label> labels = labelDao.findAllLabels();

        // 함수형 프로그래밍
        List<LabelSummary> labelSummaries = labels.stream()
                                                 .map(label -> of(label.getId(), label.getName(), label.getBackgroundColor(), label.getColor()))
                                                 .collect(Collectors.toList());

        return LabelInformation.of(labels.size(), labelSummaries);
    }

    public ContainedDescriptionLabelInformation containDescriptionLabelInformation() {
        List<Label> labels = labelDao.findAllLabels();

        // 함수형 프로그래밍
        List<ContainedDescriptionLabelSummary> labelSummaries = labels.stream()
                                                                      .map(label -> ContainedDescriptionLabelSummary.of(label.getId(), label.getName(), label.getDescription(), label.getBackgroundColor(), label.getColor()))
                                                                      .collect(Collectors.toList());

        return ContainedDescriptionLabelInformation.of(labels.size(), labelSummaries);
    }

    public List<LabelSummary> findLabelSummariesByIssueId(Long issueId) {
        return labelDao.findLabelSummariesByIssueId(issueId);
    }

    public void create(NewLabelDto newLabelDto) {
        labelDao.create(newLabelDto);
    }
}
