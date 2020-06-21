package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.CommentDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Comment;
import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.dto.request.NewCommentDto;
import com.codesquad.issuetracker.hamill.dto.request.NewIssueDto;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import com.codesquad.issuetracker.hamill.vo.commentVO.CommentSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(CommentService_Hamill.class);

    private final CommentDao_Hamill commentDao_hamill;

    public CommentService_Hamill(CommentDao_Hamill commentDao_hamill) {
        this.commentDao_hamill = commentDao_hamill;
    }

    public List<CommentSummary> findCommentSummaries() {
        List<Comment> comments = commentDao_hamill.findAllComments();
        List<CommentSummary> commentSummaries = new ArrayList<>();

        for (Comment value : comments) {
            CommentSummary commentSummary = CommentSummary.of(value.getId(), value.getDescription(), value.getCreatedDateTime(), value.getUserId());
            commentSummaries.add(commentSummary);
        }

        return commentSummaries;
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
