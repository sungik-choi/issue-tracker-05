package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.dto.request.NewCommentDto;
import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.CommentService_Hamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hamill/api/issues")
public class CommentController_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(CommentController_Hamill.class);

    private final CommentService_Hamill commentService_hamill;

    public CommentController_Hamill(CommentService_Hamill commentService_hamill) {
        this.commentService_hamill = commentService_hamill;
    }

    @PostMapping("/{issueId}/comments")
    public ResponseEntity<ApiResponse<?>> create(@PathVariable Long issueId, @RequestBody NewCommentDto newCommentDto) {
        commentService_hamill.create(issueId, newCommentDto);
        return new ResponseEntity<>(ApiResponse.OK("상세페이지에서 새로운 코멘트 생성 성공"), HttpStatus.OK);
    }
}
