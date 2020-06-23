package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.MilestoneDao;
import com.codesquad.issuetracker.main.domain.Milestone;
import com.codesquad.issuetracker.main.vo.milestoneVO.MilestoneInformation;
import com.codesquad.issuetracker.main.vo.milestoneVO.MilestoneSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MilestoneService {

    private static final Logger logger = LoggerFactory.getLogger(MilestoneService.class);

    private MilestoneDao milestoneDao;

    public MilestoneService(MilestoneDao milestoneDao) {
        this.milestoneDao = milestoneDao;
    }

    public MilestoneInformation findMilestoneInformation() {
        List<Milestone> milestones = milestoneDao.findAllMilestones();

        List<MilestoneSummary> milestoneSummaries = new ArrayList<>();
        for (Milestone value : milestones) {
            MilestoneSummary milestoneSummary = MilestoneSummary.of(value.getId(), value.getTitle(), value.getProgress());
            milestoneSummaries.add(milestoneSummary);
        }

        return MilestoneInformation.of(milestones.size(), milestoneSummaries);
    }

    public Milestone findMilestoneByMilestoneId(Integer milestoneId) {
        return milestoneDao.findMilestoneByMilestoneId(milestoneId);
    }

}
