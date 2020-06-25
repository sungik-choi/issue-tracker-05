//package com.codesquad.issuetracker.ragdoll.controller;
//
//import com.codesquad.issuetracker.ragdoll.dto.ListOfIssuesDto;
//import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
//import com.codesquad.issuetracker.ragdoll.service.IssueService_Ragdoll;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/ragdoll")
//public class IssueController_Ragdoll {
//
//    private final IssueService_Ragdoll issueService;
//
//    public IssueController_Ragdoll(IssueService_Ragdoll issueService) {
//        this.issueService = issueService;
//    }
//
//    @GetMapping("/issues")
//    public ResponseEntity<ApiResponse<ListOfIssuesDto>> listing() {
//        return new ResponseEntity(issueService.findAllIssues(), HttpStatus.OK);
//    }
//}
