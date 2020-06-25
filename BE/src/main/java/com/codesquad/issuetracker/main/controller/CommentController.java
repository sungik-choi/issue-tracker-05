package com.codesquad.issuetracker.main.controller;

import com.codesquad.issuetracker.main.dto.request.NewCommentDto;
import com.codesquad.issuetracker.main.dto.response.ApiResponse;
import com.codesquad.issuetracker.main.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;

@RestController
@RequestMapping("/issues")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{issueId}/comments")
    public ResponseEntity<ApiResponse<?>> create(@PathVariable Long issueId, @RequestBody NewCommentDto newCommentDto) {
        commentService.create(issueId, newCommentDto);
        return new ResponseEntity<>(ApiResponse.OK("상세페이지에서 새로운 코멘트 생성 성공"), HttpStatus.OK);
    }

    @PatchMapping("/{issueId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<?>> update(
            @PathVariable Long issueId, @PathVariable Long commentId, @RequestBody NewCommentDto newCommentDto) throws AuthenticationException {
        try {
            commentService.update(issueId, commentId, newCommentDto);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(ApiResponse.UNAUTHORIZED("권한이 없습니다. 사용자 인증 후 다시 요청 해주세요."), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }

    @DeleteMapping("/{issueId}/comments/{commentId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long issueId, @PathVariable Long commentId, @RequestBody HashMap<String,Long> map) throws AuthenticationException {
        logger.info("##### userId: {}", map.get("userId"));
        try {
            commentService.delete(issueId, commentId, map.get("userId"));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(ApiResponse.UNAUTHORIZED("권한이 없습니다. 사용자 인증 후 다시 요청 해주세요."), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
    }
}
