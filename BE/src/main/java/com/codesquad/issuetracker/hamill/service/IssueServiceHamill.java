package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.IssueDaoHamill;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.codesquad.issuetracker.hamill.dto.info.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueServiceHamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueServiceHamill.class);
    private static final int ZERO = 0;

    private IssueDaoHamill issueDaoHamill;

    public IssueServiceHamill(IssueDaoHamill issueDaoHamill) {
        this.issueDaoHamill = issueDaoHamill;
    }

    public List<IssuesDto> findAllIssues() {

        List<IssuesDto> ListTypeIssuesDto = new ArrayList<>();

        for (int i = ZERO; i < issueDaoHamill.getCountOfIssues(); i++) {
            ListTypeIssuesDto.add(i, findIssueByIssueId(i + 1L)); // issue ID는 1부터 시작
        }

        return ListTypeIssuesDto;
    }

    public IssuesDto findIssueByIssueId(Long issueId) {

        IssuesDto issuesDto = issueDaoHamill.findIssueByIssueId(issueId);
        issuesDto.setAttachedLabels(issueDaoHamill.findLabelsByIssuesId(issueId));
        issuesDto.setAllocatedAssignees(issueDaoHamill.findAssigneeByIssueId(issueId));
        return issuesDto;
    }

    public IssuesDto save(RequestNewIssueDto requestNewIssueDto) {
        Long newIssueId = issueDaoHamill.getCountOfIssues() + 1L;
        issueDaoHamill.saveNewIssue(
                newIssueId,
                requestNewIssueDto.getTitle(),
                requestNewIssueDto.getUserId(),
                requestNewIssueDto.getMilestone().getMilestoneId());

        saveNewIssueHasLabel(requestNewIssueDto);
        saveAssignees(requestNewIssueDto);

        IssuesDto issuesDto = issueDaoHamill.findIssueByIssueId(newIssueId);
        issuesDto.setAttachedLabels(requestNewIssueDto.getAttachedLabels());
        issuesDto.setAllocatedAssignees(requestNewIssueDto.getAllocatedAssignees());
        logger.info("##### issueDto: {}", issuesDto);
        logger.info("##### getAllocatedAssignees: {}", requestNewIssueDto.getAllocatedAssignees());
        logger.info("##### getAllocatedAssignees: {}", requestNewIssueDto.getAttachedLabels());

        return issuesDto;
    }

    private void saveNewIssueHasLabel(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAttachedLabels().size(); i++) {
            issueDaoHamill.saveNewIssueHasLabel(requestNewIssueDto.getAttachedLabels().get(i).getLabelId(), (long)issueDaoHamill.getCountOfIssues());
        }
    }

    private void saveAssignees(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAllocatedAssignees().size(); i++) {
            issueDaoHamill.saveAssignees((long)issueDaoHamill.getCountOfIssues(), requestNewIssueDto.getAllocatedAssignees().get(i).getUserId());
        }
    }

}
