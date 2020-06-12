package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.ragdoll.dao.MilestoneDaoRagdoll;
import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import com.codesquad.issuetracker.ragdoll.dto.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.ragdoll.dto.milestoneVO.MilestoneSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MilestoneService {

    private MilestoneDaoRagdoll milestoneDaoRagdoll;

    public MilestoneService(MilestoneDaoRagdoll milestoneDaoRagdoll) {
        this.milestoneDaoRagdoll = milestoneDaoRagdoll;
    }

    public Milestone findMilestoneById(Integer milestoneId) {
        return milestoneDaoRagdoll.findMilestoneById(milestoneId);
    }

    public MilestoneInformation findAllMilestones() {
        List<Milestone> milestones = milestoneDaoRagdoll.findAllMilestones();
        Set<MilestoneSummary> milestoneSummaries = milestones.stream()
                                                             .map(milestone -> MilestoneSummary.create(milestone.getId(), milestone.getTitle()))
                                                             .collect(Collectors.toSet());
        return MilestoneInformation.create(milestoneSummaries.size(), milestoneSummaries);
    }
}
