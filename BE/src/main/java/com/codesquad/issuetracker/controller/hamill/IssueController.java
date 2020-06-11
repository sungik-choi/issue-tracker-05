package com.codesquad.issuetracker.controller.hamill;

import com.codesquad.issuetracker.dto.hamill.IssueListDto;
import com.codesquad.issuetracker.dto.hamill.info.IssuesDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelInfoDto;
import com.codesquad.issuetracker.service.hamill.IssueService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueController {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    private IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/api/issues")
    public ResponseEntity<List<IssuesDto>> list() {
        return new ResponseEntity<>(issueService.findAllIssues(), HttpStatus.OK);
    }

    @GetMapping("/api/issues/{issueId}")
    public ResponseEntity<IssuesDto> findIssuesByIssueId(@PathVariable Long issueId) {
        return new ResponseEntity<>(issueService.findIssuesByIssueId(issueId), HttpStatus.OK);
    }
 }
