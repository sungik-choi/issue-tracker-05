package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;
import com.codesquad.issuetracker.ragdoll.dao.IssueDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Comment;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.DetailedInformationOfIssueDto;
import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.dto.SubmitNewIssueRequestDto;
import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentDetails;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueService_Ragdoll {

    private final IssueDao_Ragdoll issueDao;

    private final UserService_Ragdoll userService;

    private final MilestoneService_Ragdoll milestoneService;

    private final LabelService_Ragdoll labelService;

    public IssueService_Ragdoll(IssueDao_Ragdoll issueDao, UserService_Ragdoll userService, MilestoneService_Ragdoll milestoneService, LabelService_Ragdoll labelService) {
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
        Optional<Milestone> foundMilestone = Optional.ofNullable(milestoneService.findMilestoneById(issue.getMilestoneId()));
        List<LabelSummary> attachedLabels = labelService.findAttachedLabelsByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userService.findAllocatedAssigneesByIssueId(issue.getId());
        User user = userService.findUserById(issue.getUserId());
        return new IssueDetails.Builder()
                               .issueId(issue.getId())
                               .issueTitle(issue.getTitle())
                               .milestone(determineMilestone(foundMilestone))
                               .attachedLabels(attachedLabels)
                               .author(UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl()))
                               .allocatedAssignees(allocatedAssignees)
                               .createdAt(issue.getCreatedDateTime())
                               .opened(issue.isOpened())
                               .build();
    }

    private MilestoneSummary determineMilestone(Optional<Milestone> foundMilestone) {
        if (foundMilestone.isPresent()) {
            Milestone milestone = foundMilestone.get();
            return MilestoneSummary.create(milestone.getId(), milestone.getTitle());
        }
        return null;
    }

    public String submitNewIssue(SubmitNewIssueRequestDto submitNewIssueRequestDto) {
        Long newIssueId = issueDao.submitNewIssue(submitNewIssueRequestDto.getUserId(),
                                                            submitNewIssueRequestDto.getTitle());
        issueDao.submitNewComment(submitNewIssueRequestDto.getUserId(), newIssueId,
                                    submitNewIssueRequestDto.getDescription());
        return ResponseMessages.SUCCESSFULLY_CREATED;
    }

    public DetailedInformationOfIssueDto showIssueDetails(Long issueId) {
        Issue issue = issueDao.findIssueById(issueId);
        List<Comment> allCommentsOfIssue = issueDao.findAllCommentsByIssueId(issueId);
        List<CommentDetails> comments = allCommentsOfIssue.stream().map(comment -> {
            User user = userService.findUserById(comment.getUserId());
            UserSummary commenter = UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl());
            return CommentDetails.create(commenter, comment.getDescription(), comment.getCreatedDateTime());
        }).collect(Collectors.toList());
        return new DetailedInformationOfIssueDto.Builder()
                                                .issue(mapToIssueDetails(issue))
                                                .comments(comments)
                                                .labelInfo(labelService.findAllLabels())
                                                .milestoneInfo(milestoneService.findAllMilestones())
                                                .assigneeInfo(userService.findAllAssignees())
                                                .build();
    }
}
