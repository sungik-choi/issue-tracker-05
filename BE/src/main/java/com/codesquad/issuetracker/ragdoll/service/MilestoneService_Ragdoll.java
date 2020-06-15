package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.MilestoneDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
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
}
