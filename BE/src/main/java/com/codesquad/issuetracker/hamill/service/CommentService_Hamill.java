package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.CommentDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.Comment;
import com.codesquad.issuetracker.hamill.domain.User;
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

    public void save(NewIssueDto newIssueDto) {
        commentDao_hamill.save(newIssueDto);
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
}
