package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.CommentDao_Hamill;
import com.codesquad.issuetracker.hamill.dao.IssueDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Comment;
import com.codesquad.issuetracker.hamill.domain.Issue;
import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.dto.request.NewCommentDto;
import com.codesquad.issuetracker.hamill.dto.request.NewIssueDto;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.hamill.vo.commentVO.CommentSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(CommentService_Hamill.class);

    private final CommentDao_Hamill commentDao_hamill;
    private final UserService_Hamill userService_hamill;

    public CommentService_Hamill(CommentDao_Hamill commentDao_hamill, UserService_Hamill userService_hamill) {
        this.commentDao_hamill = commentDao_hamill;
        this.userService_hamill = userService_hamill;
    }

    public CommentInformation findCommentInformation(Issue issue) {
        List<Comment> comments = commentDao_hamill.findAllCommentsByIssueId(issue.getId());

        List<CommentSummary> commentSummaries = comments.stream()
                .map(this::mapToUserSummaryInCommentSummary).collect(Collectors.toList());

        return CommentInformation.of(comments.size(), commentSummaries);
    }

    private CommentSummary mapToUserSummaryInCommentSummary(Comment comment) {
        User user = userService_hamill.findUserByUserId(comment.getUserId());
        UserSummary userSummary = UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl());

        return CommentSummary.of(
                comment.getId(),
                comment.getDescription(),
                comment.getCreatedDateTime(),
                userSummary
        );
    }

    public Comment findCommentByIssueId(Long issueId) {
        return commentDao_hamill.findCommentByIssueId(issueId);
    }

    // 이슈를 새로 생성할 때 comment 테이블에 데이터를 저장합니다
    public void save(NewIssueDto newIssueDto) {
        commentDao_hamill.save(newIssueDto);
    }

    // 상세 페이지에서 코멘트를 추가합니다
    public void create(Long issueId, NewCommentDto newCommentDto) {
        commentDao_hamill.create(issueId, newCommentDto);
    }
}
