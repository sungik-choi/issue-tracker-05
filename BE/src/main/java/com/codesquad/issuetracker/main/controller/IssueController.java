//package com.codesquad.issuetracker.main.controller;
//
//import com.codesquad.issuetracker.common.CommonMessage;
//import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
//import com.codesquad.issuetracker.main.dto.RequestNewIssueDto;
//import com.codesquad.issuetracker.main.service.IssueService;
//import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
//import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class IssueController {
//
//    private final IssueService issueService;
//
//    public IssueController(IssueService issueService) {
//        this.issueService = issueService;
//    }
//
//    @GetMapping("/issues")
//    public ResponseEntity<ApiResponse<ListOfIssuesDto>> listing() {
//        return new ResponseEntity(issueService.findAllIssues(), HttpStatus.OK);
//    }
//
//    @PostMapping("/api/issues")
//    public ResponseEntity<CommonMessage> create(@RequestBody RequestNewIssueDto requestNewIssueDto) {
//        issueService.save(requestNewIssueDto);
//        return new ResponseEntity<>(getMessage("200", "이슈 생성 성공"), HttpStatus.OK);
//    }
//
//    private CommonMessage getMessage(String statusCode, String message) {
//
//        return CommonMessage.builder()
//                            .statusCode(statusCode)
//                            .message(message)
//                            .build();
//    }
//}
