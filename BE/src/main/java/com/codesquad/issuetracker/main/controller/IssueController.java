package com.codesquad.issuetracker.main.controller;

import com.codesquad.issuetracker.main.dto.request.*;
import com.codesquad.issuetracker.main.dto.response.ApiResponse;
import com.codesquad.issuetracker.main.dto.response.IssueDto;
import com.codesquad.issuetracker.main.dto.response.ListOfIssuesDto;
import com.codesquad.issuetracker.main.service.IssueService;
import com.codesquad.issuetracker.main.service.LabelService;
import com.codesquad.issuetracker.main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    private IssueService issueService;
    private LabelService labelService;
    private UserService userService;

    public IssueController(IssueService issueService, LabelService labelService, UserService userService) {
        this.issueService = issueService;
        this.labelService = labelService;
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<ListOfIssuesDto>> showIssues() {
        return new ResponseEntity<>(ApiResponse.OK(issueService.getIssuesAndAllElements()), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> create(@RequestBody NewIssueDto newIssueDto) {
        issueService.save(newIssueDto);
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity<ApiResponse<IssueDto>> showIssue(@PathVariable Long issueId) {
        return new ResponseEntity<>(ApiResponse.OK(issueService.getIssueAndAllElements(issueId)), HttpStatus.OK);
    }

    @PatchMapping("{issueId}/title")
    public ResponseEntity<com.codesquad.issuetracker.hamill.dto.response.ApiResponse<?>> updateTitle(@PathVariable Long issueId, @RequestBody UpdateTitleDto updateTitleDto) throws AuthenticationException {
        try {
            issueService.updateTitle(issueId, updateTitleDto);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.UNAUTHORIZED("권한이 없습니다. 사용자 인증 후 다시 요청 해주세요."), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    // 이슈 Open/Closed 수정 기능
    @PatchMapping("/mark")
    public ResponseEntity<com.codesquad.issuetracker.hamill.dto.response.ApiResponse<?>> updateStatusOfIssue(@RequestBody UpdateStateOfIssueDto updateStateOfIssueDto) {
        issueService.updateStateOfIssue(updateStateOfIssueDto);

        return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    // 이슈에 달려있는 label 추가, 삭제
    @PutMapping("/{issueId}/labels")
    public ResponseEntity<com.codesquad.issuetracker.hamill.dto.response.ApiResponse<?>> updateAttachedLabels(@PathVariable Long issueId, @RequestBody UpdateAttachedLabelsDto updateAttachedLabelsDto) {
        labelService.updateAttachedLabels(issueId, updateAttachedLabelsDto);

        return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    // 이슈에 달려있는 milestone 추가, 삭제
    @PatchMapping("/{issueId}/milestone")
    public ResponseEntity<com.codesquad.issuetracker.hamill.dto.response.ApiResponse<?>> updateMilestoneIdOfIssue(@PathVariable Long issueId,
                                                                                                                  @RequestBody UpdateMilestoneIdOfIssueDto updateMilestoneIdOfIssueDto) {
        issueService.updateMilestoneIdOfIssue(issueId, updateMilestoneIdOfIssueDto);

        return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    // 이슈에 달려있는 assignee 추가, 삭제
    @PutMapping("/{issueId}/assignees")
    public ResponseEntity<com.codesquad.issuetracker.hamill.dto.response.ApiResponse<?>> updateAllocatedAssignees(@PathVariable Long issueId,
                                                                                                                  @RequestBody UpdateAllocatedAssigneesDto updateAllocatedAssigneesDto) {
        userService.updateAllocatedAssignees(issueId, updateAllocatedAssigneesDto);

        return new ResponseEntity<>(com.codesquad.issuetracker.hamill.dto.response.ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
 }
