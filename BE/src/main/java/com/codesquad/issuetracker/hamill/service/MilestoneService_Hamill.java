package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.MilestoneDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Milestone;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.hamill.vo.milestoneVO.MilestoneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MilestoneService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(MilestoneService_Hamill.class);

    private MilestoneDao_Hamill milestoneDao_hamill;

    public MilestoneService_Hamill(MilestoneDao_Hamill milestoneDao_hamill) {
        this.milestoneDao_hamill = milestoneDao_hamill;
    }

    public MilestoneInformation findMilestoneInformation() {
        List<Milestone> milestones = milestoneDao_hamill.findAllMilestones();

        Set<MilestoneSummary> milestoneSummaries = new HashSet<>();
        for (Milestone value : milestones) {
            MilestoneSummary milestoneSummary = MilestoneSummary.of(value.getId(), value.getTitle());
            milestoneSummaries.add(milestoneSummary);
        }

        return MilestoneInformation.of(milestones.size(), milestoneSummaries);
    }

    public Milestone findMilestoneByMilestoneId(Integer milestoneId) {
        return milestoneDao_hamill.findMilestoneByMilestoneId(milestoneId);
    }

}
