package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.IssueDao;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.dto.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.dto.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.dto.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.dto.milestoneVO.MilestoneSummary;
import com.codesquad.issuetracker.ragdoll.dto.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private IssueDao issueDao;

    private UserService userService;

    private MilestoneService milestoneService;

    private LabelService labelService;

    public IssueService(IssueDao issueDao, UserService userService, MilestoneService milestoneService, LabelService labelService) {
        this.issueDao = issueDao;
        this.userService = userService;
        this.milestoneService = milestoneService;
        this.labelService = labelService;
    }

    public ListOfIssuesDto findAllIssues() {
        List<Issue> allOfOpenedIssues = issueDao.findAllOpendIssues();
        List<IssueDetails> issues = allOfOpenedIssues.stream()
                                                     .map(this::mapToIssueDetails)
                                                     .collect(Collectors.toList());
        LabelInformation labelInformation = labelService.findAllLabels();
        MilestoneInformation milestoneInformation = milestoneService.findAllMilestones();
        List<UserSummary> assigneeInformation = userService.findAllAssignees();
        return new ListOfIssuesDto.Builder()
                                  .issues(issues)
                                  .labelInfo(labelInformation)
                                  .milestoneInfo(milestoneInformation)
                                  .assigneeInfo(assigneeInformation)
                                  .build();
    }

    private IssueDetails mapToIssueDetails(Issue issue) {
        Milestone milestone = milestoneService.findMilestoneById(issue.getMilestoneId());
        List<LabelSummary> attachedLabels = labelService.findAttachedLabelsByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userService.findAllocatedAssigneesByIds(issue.getId());
        User user = userService.findUserById(issue.getUserId());
        return new IssueDetails.Builder()
                               .issueId(issue.getId())
                               .issueTitle(issue.getTitle())
                               .milestone(MilestoneSummary.create(milestone.getId(), milestone.getTitle()))
                               .attachedLabels(attachedLabels)
                               .author(UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl()))
                               .allocatedAssignees(allocatedAssignees)
                               .createdAt(issue.getCreatedDateTime())
                               .opened(issue.isOpened())
                               .build();
    }
}
