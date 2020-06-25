package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.dto.request.NewCommentDto;
import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.CommentService_Hamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;

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
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @PatchMapping("/{issueId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<?>> update(
            @PathVariable Long issueId, @PathVariable Long commentId, @RequestBody NewCommentDto newCommentDto) throws AuthenticationException {
        try {
            commentService_hamill.update(issueId, commentId, newCommentDto);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(ApiResponse.UNAUTHORIZED("권한이 없습니다. 사용자 인증 후 다시 요청 해주세요."), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @DeleteMapping("/{issueId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long issueId, @PathVariable Long commentId, @RequestBody HashMap<String,Long> map) throws AuthenticationException {
        logger.info("##### userId: {}", map.get("userId"));
        try {
            commentService_hamill.delete(issueId, commentId, map.get("userId"));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(ApiResponse.UNAUTHORIZED("권한이 없습니다. 사용자 인증 후 다시 요청 해주세요."), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
}
