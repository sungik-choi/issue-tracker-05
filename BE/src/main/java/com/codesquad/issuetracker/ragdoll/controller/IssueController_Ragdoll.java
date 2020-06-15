package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.DetailedInformationOfIssueDto;
import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.dto.ModifyIssueTitleRequestDto;
import com.codesquad.issuetracker.ragdoll.dto.SubmitNewIssueRequestDto;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.IssueService_Ragdoll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ragdoll")
public class IssueController_Ragdoll {

    private final IssueService_Ragdoll issueService;

    public IssueController_Ragdoll(IssueService_Ragdoll issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public ResponseEntity<ApiResponse<ListOfIssuesDto>> listing() {
        return new ResponseEntity(ApiResponse.OK(issueService.findAllIssues()), HttpStatus.OK);
    }

    @PostMapping("/issues")
    public ResponseEntity<ApiResponse<String>> submit(@RequestBody SubmitNewIssueRequestDto submitNewIssueRequestDto) {
        return new ResponseEntity(ApiResponse.CREATED(issueService.submitNewIssue(submitNewIssueRequestDto)), HttpStatus.CREATED);
    }

    @GetMapping("/issues/{issueId}")
    public ResponseEntity<ApiResponse<DetailedInformationOfIssueDto>> showDetails(@PathVariable Long issueId) {
        return new ResponseEntity(ApiResponse.OK(issueService.showIssueDetails(issueId)), HttpStatus.OK);
    }

    @PatchMapping("/issues/{issueId}/title")
    public ResponseEntity<ApiResponse<String>> modifyTitle(@PathVariable Long issueId, @RequestBody ModifyIssueTitleRequestDto modifyIssueTitleRequestDto) {
        return new ResponseEntity(ApiResponse.OK(issueService.modifyIssueTitle(issueId, modifyIssueTitleRequestDto)), HttpStatus.OK);
    }
}
