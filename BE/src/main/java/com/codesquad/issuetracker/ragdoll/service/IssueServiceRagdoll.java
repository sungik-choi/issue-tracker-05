package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.IssueDaoRagdoll;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueServiceRagdoll {

    private final IssueDaoRagdoll issueDaoRagdoll;

    private final UserServiceRagdoll userServiceRagdoll;

    private final MilestoneServiceRagdoll milestoneServiceRagdoll;

    private final LabelServiceRagdoll labelServiceRagdoll;

    public IssueServiceRagdoll(IssueDaoRagdoll issueDaoRagdoll, UserServiceRagdoll userServiceRagdoll, MilestoneServiceRagdoll milestoneServiceRagdoll, LabelServiceRagdoll labelServiceRagdoll) {
        this.issueDaoRagdoll = issueDaoRagdoll;
        this.userServiceRagdoll = userServiceRagdoll;
        this.milestoneServiceRagdoll = milestoneServiceRagdoll;
        this.labelServiceRagdoll = labelServiceRagdoll;
    }

    public ListOfIssuesDto findAllIssues() {
        List<Issue> allOfOpenedIssues = issueDaoRagdoll.findAllOpendIssues();
        List<IssueDetails> issues = allOfOpenedIssues.stream()
                                                     .map(this::mapToIssueDetails)
                                                     .collect(Collectors.toList());
        LabelInformation labelInformation = labelServiceRagdoll.findAllLabels();
        MilestoneInformation milestoneInformation = milestoneServiceRagdoll.findAllMilestones();
        List<UserSummary> assigneeInformation = userServiceRagdoll.findAllAssignees();
        return new ListOfIssuesDto.Builder()
                                  .issues(issues)
                                  .labelInfo(labelInformation)
                                  .milestoneInfo(milestoneInformation)
                                  .assigneeInfo(assigneeInformation)
                                  .build();
    }

    private IssueDetails mapToIssueDetails(Issue issue) {
        Milestone milestone = milestoneServiceRagdoll.findMilestoneById(issue.getMilestoneId());
        List<LabelSummary> attachedLabels = labelServiceRagdoll.findAttachedLabelsByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userServiceRagdoll.findAllocatedAssigneesByIds(issue.getId());
        User user = userServiceRagdoll.findUserById(issue.getUserId());
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
