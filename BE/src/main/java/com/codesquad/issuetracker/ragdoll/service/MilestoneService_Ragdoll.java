package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;
import com.codesquad.issuetracker.ragdoll.dao.MilestoneDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.dto.ListOfMilestonesDto;
import com.codesquad.issuetracker.ragdoll.dto.request.MilestoneRequestDto;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneDetails;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MilestoneService_Ragdoll {

    private final MilestoneDao_Ragdoll milestoneDao;

    public MilestoneService_Ragdoll(MilestoneDao_Ragdoll milestoneDao) {
        this.milestoneDao = milestoneDao;
    }

    public Milestone findMilestoneById(Integer milestoneId) {
        return milestoneDao.findMilestoneById(milestoneId);
    }

    public MilestoneInformation findAllMilestones() {
        List<Milestone> milestones = milestoneDao.findAllMilestones();
        Set<MilestoneSummary> milestoneSummaries = milestones.stream()
                                                             .map(milestone -> MilestoneSummary.create(milestone.getId(), milestone.getTitle()))
                                                             .collect(Collectors.toSet());
        return MilestoneInformation.create(milestoneSummaries.size(), milestoneSummaries);
    }

    public ListOfMilestonesDto findAllMilestonesWithDetails() {
        List<Milestone> milestones = milestoneDao.findAllMilestones();
        List<MilestoneDetails> milestoneDetails = milestones.stream().map(milestone -> {
            int countOfOpenedIssue = milestoneDao.findCountOfOpenedIssueById(milestone.getId(), true);
            int countOfClosedIssue = milestoneDao.findCountOfOpenedIssueById(milestone.getId(), false);
            int countOfAllIssue = (countOfOpenedIssue + countOfClosedIssue == 0) ? 1 : countOfOpenedIssue + countOfClosedIssue;
            double progress = ((double) countOfClosedIssue / countOfAllIssue) * 100;
            return new MilestoneDetails.Builder()
                                       .milestoneId(milestone.getId())
                                       .milestoneTitle(milestone.getTitle())
                                       .description(milestone.getDescription())
                                       .dueDate(milestone.getDueDate())
                                       .progress(progress)
                                       .countOfOpenedIssue(countOfOpenedIssue)
                                       .countOfClosedIssue(countOfClosedIssue)
                                       .build();
        }).collect(Collectors.toList());
        return new ListOfMilestonesDto.Builder().milestones(milestoneDetails).build();
    }

    public String createNewMilestone(MilestoneRequestDto milestoneRequestDto) {
        milestoneDao.createNewMilestone(milestoneRequestDto.getTitle(), milestoneRequestDto.getDueDate(), milestoneRequestDto.getDescription());
        return ResponseMessages.SUCCESSFULLY_CREATED;
    }

    public String updateMilestone(Integer milestoneId, MilestoneRequestDto milestoneRequestDto) {
        milestoneDao.updateMilestone(milestoneId, milestoneRequestDto.getTitle(), milestoneRequestDto.getDueDate(),
                                     milestoneRequestDto.getDescription());
        return ResponseMessages.SUCCESSFULLY_MODIFIED;
    }

    public String deleteMilestone(Integer milestoneId) {
        milestoneDao.deleteMilestone(milestoneId);
        return ResponseMessages.SUCCESSFULLY_DELETED;
    }
}
