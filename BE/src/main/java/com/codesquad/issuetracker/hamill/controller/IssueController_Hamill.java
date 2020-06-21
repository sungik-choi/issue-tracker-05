package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.dto.ListOfIssuesDto;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import com.codesquad.issuetracker.hamill.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.IssueService_Hamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hamill")
public class IssueController_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueController_Hamill.class);

    private IssueService_Hamill issueService_Hamill;

    public IssueController_Hamill(IssueService_Hamill issueService_Hamill) {
        this.issueService_Hamill = issueService_Hamill;
    }

    @GetMapping("/issues")
    public ResponseEntity<ApiResponse<ListOfIssuesDto>> showList() {
        return new ResponseEntity<>(ApiResponse.OK(issueService_Hamill.getIssuesAndAllElements()), HttpStatus.OK);
    }

    @PostMapping("/api/issues")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody RequestNewIssueDto requestNewIssueDto) {
        issueService_Hamill.save(requestNewIssueDto);
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
 }
