package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dto.request.NewLabelDto;
import com.codesquad.issuetracker.main.dto.request.UpdateAttachedLabelsDto;
import com.codesquad.issuetracker.main.dao.IssueHasLabelDao;
import com.codesquad.issuetracker.main.dao.LabelDao;
import com.codesquad.issuetracker.main.domain.Label;
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
    private IssueHasLabelDao issueHasLabelDao;

    public LabelService(LabelDao labelDao, IssueHasLabelDao issueHasLabelDao) {
        this.labelDao = labelDao;
        this.issueHasLabelDao = issueHasLabelDao;
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

    public void updateAttachedLabels(Long issueId, UpdateAttachedLabelsDto updateAttachedLabelsDto) {
        for (int i = 0; i < updateAttachedLabelsDto.getAddedLabelsId().size(); i++) {
            issueHasLabelDao.addedAttachedLabel(issueId, updateAttachedLabelsDto.getAddedLabelsId().get(i));
        }

        for (int i = 0; i< updateAttachedLabelsDto.getDeletedLabelsId().size(); i++) {
            issueHasLabelDao.deletedAttachedLabel(issueId, updateAttachedLabelsDto.getDeletedLabelsId().get(i));
        }
    }

    public void create(NewLabelDto newLabelDto) {
        labelDao.create(newLabelDto);
    }

    public void update(Integer labelId, NewLabelDto newLabelDto) throws Exception {
        // backgroundColor 와 color 의 형태가 hex code 형태이어야 한다
        if (!(newLabelDto.getBackgroundColor().startsWith("#") && newLabelDto.getColor().startsWith("#"))) {
            throw new Exception("backgroundColor, color 를 hex code 형식으로 넣어주세요(예:#ffffff)");
        }
        labelDao.update(labelId, newLabelDto);
    }

    public void delete(Integer labelId) {
        issueHasLabelDao.deleteIssueHasLabelByLabelId(labelId);
        labelDao.delete(labelId);
    }
}
