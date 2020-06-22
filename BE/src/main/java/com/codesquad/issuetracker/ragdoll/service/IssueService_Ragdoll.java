package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.commonconstant.ErrorMessages;
import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;
import com.codesquad.issuetracker.ragdoll.dao.IssueDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Comment;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.*;
import com.codesquad.issuetracker.ragdoll.dto.request.*;
import com.codesquad.issuetracker.ragdoll.exception.UserUnauthorizedException;
import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentDetails;
import com.codesquad.issuetracker.ragdoll.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                               .author(UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl()))
                               .allocatedAssignees(allocatedAssignees)
                               .createdAt(issue.getCreatedDateTime())
                               .opened(issue.isOpened())
                               .build();
    }

    private MilestoneSummary determineMilestone(Optional<Milestone> foundMilestone) {
        if (foundMilestone.isPresent()) {
            Milestone milestone = foundMilestone.get();
            List<Issue> issuesInMilestone = issueDao.findIssuesByMilestoneId(milestone.getId());
            int countOfOpenedIssue = (int) issuesInMilestone.stream().filter(Issue::isOpened).count();
            Double progress = (1 - (double) countOfOpenedIssue / issuesInMilestone.size()) * 100;
            return MilestoneSummary.of(milestone.getId(), milestone.getTitle(), progress);
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
        List<CommentDetails> comments = allCommentsOfIssue.stream()
                                                          .map(this::mapToCommentDetails)
                                                          .collect(Collectors.toList());
        return new DetailedInformationOfIssueDto.Builder()
                                                .issue(mapToIssueDetails(issue))
                                                .commentInfo(CommentInformation.of(comments.size(), comments))
                                                .labelInfo(labelService.findAllLabels())
                                                .milestoneInfo(milestoneService.findAllMilestones())
                                                .assigneeInfo(userService.findAllAssignees())
                                                .build();
    }

    public String updateIssueTitle(Long issueId, UpdateIssueTitleRequestDto updateIssueTitleRequestDto) {
        Issue targetIssue = issueDao.findIssueById(issueId);
        if (isUnauthorizedUser(targetIssue.getUserId(), updateIssueTitleRequestDto.getUserId())) {
            throw new UserUnauthorizedException(ErrorMessages.USER_UNAUTHORIZED);
        }
        issueDao.modifyIssueTitle(issueId, updateIssueTitleRequestDto.getIssueTitle());
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    private boolean isUnauthorizedUser(Long bindUserId, Long requestUserId) {
        return !bindUserId.equals(requestUserId);
    }

    public String updateIssueStatus(UpdateIssueStatusRequestDto updateIssueStatusRequestDto) {
//        Issue targetIssue = issueDao.findIssueById(issueId);
//        if (isUnauthorizedUser(targetIssue.getUserId(), updateIssueStatusRequestDto.getUserId())) {
//            throw new UserUnauthorizedException(ErrorMessages.USER_UNAUTHORIZED);
//        }
        updateIssueStatusRequestDto.getIssueId()
                                   .forEach(issueId -> issueDao.updateIssueStatus(issueId, updateIssueStatusRequestDto.isOpened()));
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public String updateAssignees(Long issueId, UpdateAssigneesRequestDto updateAssigneesRequestDto) {
        Optional<List<Long>> addedAssigneesId = Optional.ofNullable(updateAssigneesRequestDto.getAddedAssigneesId());
        Optional<List<Long>> deletedAssigneesId = Optional.ofNullable(updateAssigneesRequestDto.getDeletedAssigneesId());
        addedAssigneesId.ifPresent(assigneeIds -> assigneeIds.forEach(assigneeId -> addAssigneeId(issueId, assigneeId)));
        deletedAssigneesId.ifPresent(assigneeIds -> assigneeIds.forEach(assigneeId -> deleteAssigneeId(issueId, assigneeId)));
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    private void addAssigneeId(Long issueId, Long addedAssigneeId) {
        issueDao.addAssigneeId(issueId, addedAssigneeId);
    }

    private void deleteAssigneeId(Long issueId, Long deletedAssigneeId) {
        issueDao.deleteAssigneeId(issueId, deletedAssigneeId);
    }

    public String updateLabels(Long issueId, UpdateLabelsRequestDto updateLabelsRequestDto) {
        Optional<List<Integer>> addedLabelsId = Optional.ofNullable(updateLabelsRequestDto.getAddedLabelsId());
        Optional<List<Integer>> deletedLabelsId = Optional.ofNullable(updateLabelsRequestDto.getDeletedLabelsId());
        addedLabelsId.ifPresent(labelIds -> labelIds.forEach(labelId -> addAttachedLabelId(issueId, labelId)));
        deletedLabelsId.ifPresent(labelIds -> labelIds.forEach(labelId -> deleteAttachedLabelId(issueId, labelId)));
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    private void addAttachedLabelId(Long issueId, Integer labelId) {
        issueDao.addAttachedLabelId(issueId, labelId);
    }

    private void deleteAttachedLabelId(Long issueId, Integer labelId) {
        issueDao.deleteAttachedLabelId(issueId, labelId);
    }

    public String updateRelatedMilestone(Long issueId, UpdateMilestoneRequestDto updateMilestoneRequestDto) {
        issueDao.updateRelatedMilestone(issueId, updateMilestoneRequestDto.getMilestoneId());
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public String submitNewComment(Long issueId, CommentsRequestDto commentsRequestDto) {
        issueDao.submitNewComment(commentsRequestDto.getUserId(), issueId, commentsRequestDto.getDescription());
        return ResponseMessages.SUCCESSFULLY_CREATED;
    }

    public String updateComment(Long issueId, Long commentId, CommentsRequestDto commentsRequestDto) {
        issueDao.updateComment(issueId, commentId, commentsRequestDto.getDescription());
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public ListOfIssuesDto findIssuesByFilterParameters(FilterParameters filterParameters) {
        List<Long> issueIdsFilteredByLabels = issueDao.findIssueIdsFilteredByLabels(filterParameters.getOpen(), filterParameters.getAuthor(),
                                                                                    filterParameters.getLabel(), filterParameters.getMilestones());
        if (issueIdsFilteredByLabels.size() == 0) { return createListOfIssues(new ArrayList<>()); }
        List<Issue> filteredIssues = issueDao.findIssuesFilteredByAssignee(issueIdsFilteredByLabels, filterParameters.getAssignee());
        return createListOfIssues(filteredIssues);
    }

    private ListOfIssuesDto createListOfIssues(List<Issue> issues) {
        List<IssueDetails> detailsOfIssues = issues.stream()
                                                   .map(this::mapToIssueDetails)
                                                   .collect(Collectors.toList());
        LabelInformation labelInformation = labelService.findAllLabels();
        MilestoneInformation milestoneInformation = milestoneService.findAllMilestones();
        List<UserSummary> assigneeInformation = userService.findAllAssignees();
        return new ListOfIssuesDto.Builder()
                                  .issues(detailsOfIssues)
                                  .labelInfo(labelInformation)
                                  .milestoneInfo(milestoneInformation)
                                  .assigneeInfo(assigneeInformation)
                                  .build();
    }

    private CommentDetails mapToCommentDetails(Comment comment) {
        User user = userService.findUserById(comment.getUserId());
        return new CommentDetails.Builder()
                                 .id(comment.getId())
                                 .description(comment.getDescription())
                                 .createdAt(comment.getCreatedDateTime())
                                 .userId(user.getId())
                                 .name(user.getName())
                                 .avatarUrl(user.getAvatarUrl())
                                 .build();
    }
}
