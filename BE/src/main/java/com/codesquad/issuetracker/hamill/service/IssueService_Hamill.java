package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.IssueDao_Hamill;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.codesquad.issuetracker.hamill.dto.info.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueService_Hamill.class);
    private static final int ZERO = 0;

    private IssueDao_Hamill issueDao_Hamill;

    public IssueService_Hamill(IssueDao_Hamill issueDao_Hamill) {
        this.issueDao_Hamill = issueDao_Hamill;
    }

    public List<IssuesDto> findAllIssues() {

        List<IssuesDto> ListTypeIssuesDto = new ArrayList<>();

        for (int i = ZERO; i < issueDao_Hamill.getCountOfIssues(); i++) {
            ListTypeIssuesDto.add(i, findIssueByIssueId(i + 1L)); // issue ID는 1부터 시작
        }

        return ListTypeIssuesDto;
    }

    public IssuesDto findIssueByIssueId(Long issueId) {

        IssuesDto issuesDto = issueDao_Hamill.findIssueByIssueId(issueId);
        issuesDto.setAttachedLabels(issueDao_Hamill.findLabelsByIssuesId(issueId));
        issuesDto.setAllocatedAssignees(issueDao_Hamill.findAssigneeByIssueId(issueId));
        return issuesDto;
    }

    public IssuesDto save(RequestNewIssueDto requestNewIssueDto) {
        Long newIssueId = issueDao_Hamill.getCountOfIssues() + 1L;
        issueDao_Hamill.saveNewIssue(
                newIssueId,
                requestNewIssueDto.getTitle(),
                requestNewIssueDto.getUserId(),
                requestNewIssueDto.getMilestone().getMilestoneId());

        saveNewIssueHasLabel(requestNewIssueDto);
        saveAssignees(requestNewIssueDto);

        IssuesDto issuesDto = issueDao_Hamill.findIssueByIssueId(newIssueId);
        issuesDto.setAttachedLabels(requestNewIssueDto.getAttachedLabels());
        issuesDto.setAllocatedAssignees(requestNewIssueDto.getAllocatedAssignees());
        logger.info("##### issueDto: {}", issuesDto);
        logger.info("##### getAllocatedAssignees: {}", requestNewIssueDto.getAllocatedAssignees());
        logger.info("##### getAllocatedAssignees: {}", requestNewIssueDto.getAttachedLabels());

        return issuesDto;
    }

    private void saveNewIssueHasLabel(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAttachedLabels().size(); i++) {
            issueDao_Hamill.saveNewIssueHasLabel(requestNewIssueDto.getAttachedLabels().get(i).getLabelId(), (long)issueDao_Hamill.getCountOfIssues());
        }
    }

    private void saveAssignees(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAllocatedAssignees().size(); i++) {
            issueDao_Hamill.saveAssignees((long)issueDao_Hamill.getCountOfIssues(), requestNewIssueDto.getAllocatedAssignees().get(i).getUserId());
        }
    }

}
