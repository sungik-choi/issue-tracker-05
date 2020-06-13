package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.MilestoneDao;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.vo.milestoneVO.MilestoneSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MilestoneService {

    private final MilestoneDao milestoneDao;

    public MilestoneService(MilestoneDao milestoneDao) {
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
