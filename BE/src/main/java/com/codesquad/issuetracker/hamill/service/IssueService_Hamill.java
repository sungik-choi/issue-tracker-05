package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.IssueDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Issue;
import com.codesquad.issuetracker.hamill.domain.Milestone;
import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import com.codesquad.issuetracker.hamill.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;

import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.codesquad.issuetracker.hamill.dto.info.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueService_Hamill.class);
    private static final int ZERO = 0;

    private IssueDao_Hamill issueDao_Hamill;
    private LabelService_Hamill labelService_hamill;
    private MilestoneService_Hamill milestoneService_hamill;
    private UserService_Hamill userService_hamill;

    public IssueService_Hamill(IssueDao_Hamill issueDao_Hamill, LabelService_Hamill labelService_hamill, MilestoneService_Hamill milestoneService_hamill, UserService_Hamill userService_hamill) {
        this.issueDao_Hamill = issueDao_Hamill;
        this.labelService_hamill = labelService_hamill;
        this.milestoneService_hamill = milestoneService_hamill;
        this.userService_hamill = userService_hamill;
    }

    public ListOfIssuesDto getIssuesAndAllElements() {
        List<Issue> issues = issueDao_Hamill.findAllIssues();
        List<IssueDetails> issueDetails = issues.stream()
                .map(this::mapToIssueDetails)
                .collect(Collectors.toList());

        LabelInformation labelInfo = labelService_hamill.findLabelInformation();
        MilestoneInformation milestoneInfo = milestoneService_hamill.findMilestoneInformation();
        List<UserSummary> userSummary = userService_hamill.findUserInformation();

        return ListOfIssuesDto.of(issueDetails, labelInfo, milestoneInfo, userSummary);
    }

    private IssueDetails mapToIssueDetails(Issue issue) {
        Milestone milestone = milestoneService_hamill.findMilestoneByMilestoneId(issue.getMilestoneId());
        List<LabelSummary> attachedLabels = labelService_hamill.findLabelSummaryByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userService_hamill.findUserSummaryByIssueId(issue.getId());
        User user = userService_hamill.findUserByUserId(issue.getUserId());

        return IssueDetails.of(
                issue.getId(),
                issue.getTitle(),
                MilestoneSummary.of(milestone.getId(), milestone.getTitle()),
                attachedLabels,
                UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl()),
                allocatedAssignees,
                issue.getCreatedDateTime(),
                issue.isOpened());
    }


    public IssuesDto findIssueByIssueId(Long issueId) {

        IssuesDto issuesDto = issueDao_Hamill.findIssueByIssueId(issueId);
        issuesDto.setAttachedLabels(issueDao_Hamill.findLabelsByIssuesId(issueId));
        issuesDto.setAllocatedAssignees(issueDao_Hamill.findAssigneeByIssueId(issueId));
        return issuesDto;
    }

    public void save(RequestNewIssueDto requestNewIssueDto) {
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
