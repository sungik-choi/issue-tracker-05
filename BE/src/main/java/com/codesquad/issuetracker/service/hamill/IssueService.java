package com.codesquad.issuetracker.service.hamill;

import com.codesquad.issuetracker.dao.hamill.IssueDao;
import com.codesquad.issuetracker.dto.hamill.info.IssuesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {

    private static final Logger logger = LoggerFactory.getLogger(IssueService.class);

    private IssueDao issueDao;

    public IssueService(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    public List<IssuesDto> findAllIssues() {
        List<IssuesDto> issuesDtos = new ArrayList<>();

        for (long i = 0; i < 5; i++) {
            issuesDtos.add((int)i,findIssuesByIssueId(i+1));
        }

        return issuesDtos;
    }

    public IssuesDto findIssuesByIssueId(Long issueId) {
        IssuesDto issuesDto = issueDao.findIssueByIssueId(issueId);
        issuesDto.setAttachedLabels(issueDao.findLabelsByIssuesId(issueId));
        issuesDto.setAllocatedAssignees(issueDao.findAssigneeByIssueId(issueId));
        return issuesDto;
    }
}
