package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.ListOfMilestonesDto;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.MilestoneService_Ragdoll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ragdoll")
public class MilestoneController_Ragdoll {

    private MilestoneService_Ragdoll milestoneService;

    public MilestoneController_Ragdoll(MilestoneService_Ragdoll milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/milestones")
    public ResponseEntity<ApiResponse<ListOfMilestonesDto>> list() {
        return new ResponseEntity(ApiResponse.OK(milestoneService.findAllMilestonesWithDetails()), HttpStatus.OK);
    }
}
