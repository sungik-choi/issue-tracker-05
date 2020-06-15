package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
import com.codesquad.issuetracker.main.dao.IssueDao;
import com.codesquad.issuetracker.main.dto.RequestNewIssueDto;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelInformation;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private static final int ZERO = 0;

    private final IssueDao issueDao;

    private final UserService userService;

    private final MilestoneService milestoneService;

    private final LabelService labelService;

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
        List<UserSummary> allocatedAssignees = userService.findAllocatedAssigneesByIssueId(issue.getId());
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

    public void save(RequestNewIssueDto requestNewIssueDto) {
        Long newIssueId = issueDao.getCountOfIssues() + 1L;
        String title = requestNewIssueDto.getTitle();
        Long userId = requestNewIssueDto.getUserId();
        Long milestoneId = requestNewIssueDto.getMilestone().getMilestoneId();

        issueDao.saveNewIssue(newIssueId, title, userId, milestoneId);
        saveNewIssueHasLabel(requestNewIssueDto);
        saveAssignees(requestNewIssueDto);

        IssuesDto issuesDto = issueDao.findIssueByIssueId(newIssueId);
        issuesDto.setAttachedLabels(requestNewIssueDto.getAttachedLabels());
        issuesDto.setAllocatedAssignees(requestNewIssueDto.getAllocatedAssignees());
    }

    private void saveNewIssueHasLabel(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAttachedLabels().size(); i++) {
            issueDao.saveNewIssueHasLabel(requestNewIssueDto.getAttachedLabels().get(i).getLabelId(), (long)issueDao.getCountOfIssues());
        }
    }

    private void saveAssignees(RequestNewIssueDto requestNewIssueDto) {
        for (int i = ZERO; i < requestNewIssueDto.getAllocatedAssignees().size(); i++) {
            issueDao.saveAssignees((long)issueDao.getCountOfIssues(), requestNewIssueDto.getAllocatedAssignees().get(i).getUserId());
        }
    }
}
