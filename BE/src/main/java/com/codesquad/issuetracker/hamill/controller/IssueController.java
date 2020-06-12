package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.common.CommonMessage;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import com.codesquad.issuetracker.hamill.hamill.info.IssuesDto;
import com.codesquad.issuetracker.hamill.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    private IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/api/issues")
    public ResponseEntity<List<IssuesDto>> showList() {
        return new ResponseEntity<>(issueService.findAllIssues(), HttpStatus.OK);
    }

    @GetMapping("/api/issues/{issueId}")
    public ResponseEntity<IssuesDto> findIssueByIssueId(@PathVariable Long issueId) {
        return new ResponseEntity<>(issueService.findIssueByIssueId(issueId), HttpStatus.OK);
    }

    @PostMapping("/api/issues")
    public ResponseEntity<IssuesDto> create(@RequestBody RequestNewIssueDto requestNewIssueDto) {
        IssuesDto issuesDto = issueService.save(requestNewIssueDto);
        return new ResponseEntity<>(issuesDto, HttpStatus.OK);
    }

    private CommonMessage getMessage(String statusCode, String message) {

        return CommonMessage.builder()
                            .statusCode(statusCode)
                            .message(message)
                            .build();
    }
 }
