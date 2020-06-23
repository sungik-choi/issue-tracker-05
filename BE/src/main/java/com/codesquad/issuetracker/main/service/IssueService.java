package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.IssueDao;
import com.codesquad.issuetracker.main.domain.Issue;
import com.codesquad.issuetracker.main.domain.Milestone;
import com.codesquad.issuetracker.main.domain.User;
import com.codesquad.issuetracker.main.dto.request.NewIssueDto;
import com.codesquad.issuetracker.main.dto.response.IssueDto;
import com.codesquad.issuetracker.main.dto.response.ListOfIssuesDto;
import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.main.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.main.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.main.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.main.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.main.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.main.vo.milestoneVO.MilestoneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private static final Logger logger = LoggerFactory.getLogger(IssueService.class);

    private IssueDao issueDao;
    private LabelService labelService;
    private MilestoneService milestoneService;
    private UserService userService;
    private CommentService commentService;

    public IssueService(IssueDao issueDao, LabelService labelService, MilestoneService milestoneService, UserService userService, CommentService commentService) {
        this.issueDao = issueDao;
        this.labelService = labelService;
        this.milestoneService = milestoneService;
        this.userService = userService;
        this.commentService = commentService;
    }

    public ListOfIssuesDto getIssuesAndAllElements() {
        List<Issue> issues = issueDao.findAllIssues();
        List<IssueDetails> issueDetails = issues.stream().map(this::mapToIssueDetails).collect(Collectors.toList());
        LabelInformation labelInfo = labelService.findLabelInformation();
        MilestoneInformation milestoneInfo = milestoneService.findMilestoneInformation();
        List<UserSummary> userSummaries = userService.findUserSummaries();

        return ListOfIssuesDto.of(issueDetails, labelInfo, milestoneInfo, userSummaries);
    }

    private IssueDetails mapToIssueDetails(Issue issue) {
        Milestone milestone = milestoneService.findMilestoneByMilestoneId(issue.getMilestoneId());
        List<LabelSummary> attachedLabels = labelService.findLabelSummariesByIssueId(issue.getId());
        List<UserSummary> allocatedAssignees = userService.findUserSummariesByIssueId(issue.getId());
        User user = userService.findUserByUserId(issue.getUserId());

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
        Issue issue = issueDao.findIssueByIssueId(issueId);
        IssueDetails issueDetail = mapToIssueDetails(issue);
        CommentInformation commentInfo = commentService.findCommentInformation(issue);
        LabelInformation labelInfo = labelService.findLabelInformation();
        MilestoneInformation milestoneInfo = milestoneService.findMilestoneInformation();
        List<UserSummary> userSummaries = userService.findUserSummaries();

        return IssueDto.of(issueDetail, commentInfo, labelInfo, milestoneInfo, userSummaries);
    }

    @Transactional
    public void save(NewIssueDto newIssueDto) {

        issueDao.save(newIssueDto);
        commentService.save(newIssueDto);
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
