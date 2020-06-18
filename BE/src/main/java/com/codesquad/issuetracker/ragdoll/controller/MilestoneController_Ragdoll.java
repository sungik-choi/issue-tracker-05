package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.ListOfMilestonesDto;
import com.codesquad.issuetracker.ragdoll.dto.MilestoneRequestDto;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.MilestoneService_Ragdoll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/milestones")
    public ResponseEntity<ApiResponse<String>> create(@RequestBody MilestoneRequestDto milestoneRequestDto) {
        return new ResponseEntity(ApiResponse.CREATED(milestoneService.createNewMilestone(milestoneRequestDto)), HttpStatus.CREATED);
    }

    @PatchMapping("/milestones/{milestoneId}")
    public ResponseEntity<ApiResponse<String>> update(@PathVariable Integer milestoneId, @RequestBody MilestoneRequestDto milestoneRequestDto) {
        return new ResponseEntity(ApiResponse.OK(milestoneService.updateMilestone(milestoneId, milestoneRequestDto)), HttpStatus.OK);
    }

    @DeleteMapping("/milestones/{milestoneId}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Integer milestoneId) {
        return new ResponseEntity(ApiResponse.OK(milestoneService.deleteMilestone(milestoneId)), HttpStatus.OK);
    }
}
