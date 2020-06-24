package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.IssueDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Issue;
import com.codesquad.issuetracker.hamill.domain.Milestone;
import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.dto.request.*;
import com.codesquad.issuetracker.hamill.dto.response.IssueDto;
import com.codesquad.issuetracker.hamill.dto.response.ListOfIssuesDto;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.hamill.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueService_Hamill.class);

    private IssueDao_Hamill issueDao_Hamill;
    private LabelService_Hamill labelService_hamill;
    private MilestoneService_Hamill milestoneService_hamill;
    private UserService_Hamill userService_hamill;
    private CommentService_Hamill commentService_hamill;

    public IssueService_Hamill(IssueDao_Hamill issueDao_Hamill, LabelService_Hamill labelService_hamill, MilestoneService_Hamill milestoneService_hamill, UserService_Hamill userService_hamill, CommentService_Hamill commentService_hamill) {
        this.issueDao_Hamill = issueDao_Hamill;
        this.labelService_hamill = labelService_hamill;
        this.milestoneService_hamill = milestoneService_hamill;
        this.userService_hamill = userService_hamill;
        this.commentService_hamill = commentService_hamill;
    }

    public ListOfIssuesDto getIssuesAndAllElements() {
        List<Issue> issues = issueDao_Hamill.findAllIssues();
        List<IssueDetails> issueDetails = issues.stream().map(this::mapToIssueDetails).collect(Collectors.toList());
        LabelInformation labelInfo = labelService_hamill.findLabelInformation();
        MilestoneInformation milestoneInfo = milestoneService_hamill.findMilestoneInformation();
        List<UserSummary> userSummaries = userService_hamill.findUserSummaries();

        return ListOfIssuesDto.of(issueDetails, labelInfo, milestoneInfo, userSummaries);
    }

    private IssueDetails mapToIssueDetails(Issue issue) {
        Milestone milestone = milestoneService_hamill.findMilestoneByMilestoneId(issue.getMilestoneId());
        List<LabelSummary> attachedLabels = labelService_hamill.findLabelSummariesByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userService_hamill.findUserSummariesByIssueId(issue.getId());
        User user = userService_hamill.findUserByUserId(issue.getUserId());

        return IssueDetails.of(
                issue.getId(),
                issue.getTitle(),
                MilestoneSummary.of(milestone.getId(), milestone.getTitle(), milestone.getProgress()),
                attachedLabels,
                UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl()),
                allocatedAssignees,
                issue.getCreatedDateTime(),
                issue.isOpened());
    }

    public IssueDto getIssueAndAllElements(Long issueId) {
        Issue issue = issueDao_Hamill.findIssueByIssueId(issueId);
        IssueDetails issueDetail = mapToIssueDetails(issue);
        CommentInformation commentInfo = commentService_hamill.findCommentInformation(issue);
        LabelInformation labelInfo = labelService_hamill.findLabelInformation();
        MilestoneInformation milestoneInfo = milestoneService_hamill.findMilestoneInformation();
        List<UserSummary> userSummaries = userService_hamill.findUserSummaries();

        return IssueDto.of(issueDetail, commentInfo, labelInfo, milestoneInfo, userSummaries);
    }

    @Transactional
    public void save(NewIssueDto newIssueDto) {

        issueDao_Hamill.save(newIssueDto);
        commentService_hamill.save(newIssueDto);
    }

    public void updateTitle(Long issueId, UpdateTitleDto updateTitleDto) throws AuthenticationException {
        // issue 작성자가 아니면 title 을 수정할 수 없다
        Issue issue = issueDao_Hamill.findIssueByIssueId(issueId);

        if (!issue.getUserId().equals(updateTitleDto.getUserId())) {
            throw new AuthenticationException("이슈 작성자가 아닙니다. 접근을 금지합니다.");
        }

        issueDao_Hamill.updateTitle(issueId, updateTitleDto.getIssueTitle());
    }

    public void updateStateOfIssue(UpdateStateOfIssueDto updateStateOfIssueDto) {
        logger.info("##### update1, {}", updateStateOfIssueDto.getUserId());
        logger.info("##### update2. {}", updateStateOfIssueDto.getIssueId());
        logger.info("##### update3, {}", updateStateOfIssueDto.isOpened());
        for (int i = 0; i < updateStateOfIssueDto.getIssueId().size(); i++) {
            issueDao_Hamill.updateStateOfIssue(updateStateOfIssueDto.isOpened(),
                    updateStateOfIssueDto.getIssueId().get(i));
        }
    }

    public void updateMilestoneIdOfIssue(Long issueId, UpdateMilestoneIdOfIssueDto updateMilestoneIdOfIssueDto) {

        issueDao_Hamill.updateMilestoneIdOfIssue(issueId, updateMilestoneIdOfIssueDto.getMilestoneId());
    }

//    public IssuesDto findIssueByIssueId(Long issueId) {
//
//        IssuesDto issuesDto = issueDao_Hamill.findIssueByIssueId(issueId);
//        issuesDto.setAttachedLabels(issueDao_Hamill.findLabelsByIssuesId(issueId));
//        issuesDto.setAllocatedAssignees(issueDao_Hamill.findAssigneeByIssueId(issueId));
//        return issuesDto;
//    }
//
//    public void save(RequestNewIssueDto requestNewIssueDto) {
//        Long newIssueId = issueDao_Hamill.getCountOfIssues() + 1L;
//        issueDao_Hamill.saveNewIssue(
//                newIssueId,
//                requestNewIssueDto.getTitle(),
//                requestNewIssueDto.getUserId(),
//                requestNewIssueDto.getMilestone().getMilestoneId());
//
//        saveNewIssueHasLabel(requestNewIssueDto);
//        saveAssignees(requestNewIssueDto);
//
//        IssuesDto issuesDto = issueDao_Hamill.findIssueByIssueId(newIssueId);
//        issuesDto.setAttachedLabels(requestNewIssueDto.getAttachedLabels());
//        issuesDto.setAllocatedAssignees(requestNewIssueDto.getAllocatedAssignees());
//    }

//    private void saveNewIssueHasLabel(RequestNewIssueDto requestNewIssueDto) {
//        for (int i = ZERO; i < requestNewIssueDto.getAttachedLabels().size(); i++) {
//            issueDao_Hamill.saveNewIssueHasLabel(requestNewIssueDto.getAttachedLabels().get(i).getLabelId(), (long)issueDao_Hamill.getCountOfIssues());
//        }
//    }
//
//    private void saveAssignees(RequestNewIssueDto requestNewIssueDto) {
//        for (int i = ZERO; i < requestNewIssueDto.getAllocatedAssignees().size(); i++) {
//            issueDao_Hamill.saveAssignees((long)issueDao_Hamill.getCountOfIssues(), requestNewIssueDto.getAllocatedAssignees().get(i).getUserId());
//        }
//    }

}
