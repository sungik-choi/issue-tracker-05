package com.codesquad.issuetracker.service.hamill;

import com.codesquad.issuetracker.dao.hamill.IssueDao;
import com.codesquad.issuetracker.dto.hamill.RequestNewIssueDto;
import com.codesquad.issuetracker.dto.hamill.info.IssuesDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {

    private static final Logger logger = LoggerFactory.getLogger(IssueService.class);
    private static final int ZERO = 0;

    private IssueDao issueDao;

    public IssueService(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    public List<IssuesDto> findAllIssues() {

        List<IssuesDto> ListTypeIssuesDto = new ArrayList<>();

        for (int i = ZERO; i < issueDao.getCountOfIssues(); i++) {
            ListTypeIssuesDto.add((int)i, findIssueByIssueId(i + 1L)); // issue ID는 1부터 시작
        }

        return ListTypeIssuesDto;
    }

    public IssuesDto findIssueByIssueId(Long issueId) {

        IssuesDto issuesDto = issueDao.findIssueByIssueId(issueId);
        issuesDto.setAttachedLabels(issueDao.findLabelsByIssuesId(issueId));
        issuesDto.setAllocatedAssignees(issueDao.findAssigneeByIssueId(issueId));
        return issuesDto;
    }

    public IssuesDto save(RequestNewIssueDto requestNewIssueDto) {
        issueDao.saveNewIssue(
                requestNewIssueDto.getTitle(),
                requestNewIssueDto.getUserId(),
                requestNewIssueDto.getMilestone().getMilestoneId());
        Long newIssueId = (long)issueDao.getCountOfIssues();

        for (int i = ZERO; i < requestNewIssueDto.getAttachedLabels().size(); i++) {
            issueDao.saveNewIssueHasLabel(newIssueId, requestNewIssueDto.getAttachedLabels().get(i).getId());
        }
        logger.info("#### request1: {}", requestNewIssueDto.getAttachedLabels());
        logger.info("#### request2: {}", requestNewIssueDto.getAllocatedAssignees());

        IssuesDto issuesDto = issueDao.findIssueByIssueId(newIssueId);
        issuesDto.setAttachedLabels(requestNewIssueDto.getAttachedLabels());
        issuesDto.setAllocatedAssignees(requestNewIssueDto.getAllocatedAssignees());

        return issuesDto;
    }
}
