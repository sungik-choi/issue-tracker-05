package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.CommentDao;
import com.codesquad.issuetracker.main.domain.Comment;
import com.codesquad.issuetracker.main.domain.Issue;
import com.codesquad.issuetracker.main.domain.User;
import com.codesquad.issuetracker.main.dto.request.NewCommentDto;
import com.codesquad.issuetracker.main.dto.request.NewIssueDto;
import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.main.vo.commentVO.CommentInformation;
import com.codesquad.issuetracker.main.vo.commentVO.CommentSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    private final CommentDao commentDao;
    private final UserService userService;

    public CommentService(CommentDao commentDao, UserService userService) {
        this.commentDao = commentDao;
        this.userService = userService;
    }

    public CommentInformation findCommentInformation(Issue issue) {
        List<Comment> comments = commentDao.findAllCommentsByIssueId(issue.getId());

        List<CommentSummary> commentSummaries = comments.stream()
                .map(this::mapToUserSummaryInCommentSummary).collect(Collectors.toList());

        return CommentInformation.of(comments.size(), commentSummaries);
    }

    private CommentSummary mapToUserSummaryInCommentSummary(Comment comment) {
        User user = userService.findUserByUserId(comment.getUserId());
        UserSummary userSummary = UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl());

        return CommentSummary.of(
                comment.getId(),
                comment.getDescription(),
                comment.getCreatedDateTime(),
                userSummary
        );
    }

    public Comment findCommentByIssueId(Long issueId) {
        return commentDao.findCommentByIssueId(issueId);
    }

    // 이슈를 새로 생성할 때 comment 테이블에 데이터를 저장합니다
    public void save(NewIssueDto newIssueDto) {
        commentDao.save(newIssueDto);
    }

    // 상세 페이지에서 코멘트를 추가합니다
    public void create(Long issueId, NewCommentDto newCommentDto) {
        commentDao.create(issueId, newCommentDto);
    }

    public void update(Long issueId, Long commentId, NewCommentDto newCommentDto) throws AuthenticationException {
        // 코멘트 작성자가 아니면 description 을 수정할 수 없다
        com.codesquad.issuetracker.hamill.domain.Comment comment = commentDao.findCommentByIssueIdAndCommentId(issueId, commentId);

        if (!comment.getUserId().equals(newCommentDto.getUserId())) {
            throw new AuthenticationException("이슈 작성자가 아닙니다. 접근을 금지합니다.");
        }

        commentDao.update(issueId, commentId, newCommentDto.getDescription());
    }

    public void delete(Long issueId, Long commentId, Long userId) throws AuthenticationException {
        com.codesquad.issuetracker.hamill.domain.Comment comment = commentDao.findCommentByIssueIdAndCommentId(issueId, commentId);

        if (!comment.getUserId().equals(userId)) {
            throw new AuthenticationException("코멘트 작성자가 아닙니다. 접근을 금지합니다.");
        }

        commentDao.delete(issueId, commentId);
    }
}
