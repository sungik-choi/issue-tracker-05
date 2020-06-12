package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.common.CommonMessage;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
import com.codesquad.issuetracker.hamill.service.IssueServiceHamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hamill")
public class IssueControllerHamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueControllerHamill.class);

    private IssueServiceHamill issueServiceHamill;

    public IssueControllerHamill(IssueServiceHamill issueServiceHamill) {
        this.issueServiceHamill = issueServiceHamill;
    }

    @GetMapping("/api/issues")
    public ResponseEntity<List<IssuesDto>> showList() {
        return new ResponseEntity<>(issueServiceHamill.findAllIssues(), HttpStatus.OK);
    }

    @GetMapping("/api/issues/{issueId}")
    public ResponseEntity<IssuesDto> findIssueByIssueId(@PathVariable Long issueId) {
        return new ResponseEntity<>(issueServiceHamill.findIssueByIssueId(issueId), HttpStatus.OK);
    }

    @PostMapping("/api/issues")
    public ResponseEntity<CommonMessage> create(@RequestBody RequestNewIssueDto requestNewIssueDto) {
        IssuesDto issuesDto = issueServiceHamill.save(requestNewIssueDto);
        return new ResponseEntity<>(getMessage("200", "새로운 이슈 생성 성공"), HttpStatus.OK);
    }

    private CommonMessage getMessage(String statusCode, String message) {

        return CommonMessage.builder()
                            .statusCode(statusCode)
                            .message(message)
                            .build();
    }
 }
