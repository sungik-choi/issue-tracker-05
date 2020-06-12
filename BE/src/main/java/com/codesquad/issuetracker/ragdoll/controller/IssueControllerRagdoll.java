package com.codesquad.issuetracker.ragdoll.controller;

import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import com.codesquad.issuetracker.ragdoll.service.IssueServiceRagdoll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ragdoll")
public class IssueControllerRagdoll {

    private final IssueServiceRagdoll issueServiceRagdoll;

    public IssueControllerRagdoll(IssueServiceRagdoll issueServiceRagdoll) {
        this.issueServiceRagdoll = issueServiceRagdoll;
    }

    @GetMapping("/issues")
    public ResponseEntity<ApiResponse<ListOfIssuesDto>> listing() {
        return new ResponseEntity(issueServiceRagdoll.findAllIssues(), HttpStatus.OK);
    }
}
