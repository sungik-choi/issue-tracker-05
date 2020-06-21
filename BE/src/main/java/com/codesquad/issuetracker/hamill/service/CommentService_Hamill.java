package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.CommentDao_Hamill;
import com.codesquad.issuetracker.hamill.dto.RequestNewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(CommentService_Hamill.class);

    private final CommentDao_Hamill commentDao_hamill;

    public CommentService_Hamill(CommentDao_Hamill commentDao_hamill) {
        this.commentDao_hamill = commentDao_hamill;
    }

    public void save(RequestNewIssueDto requestNewIssueDto) {
        commentDao_hamill.save(requestNewIssueDto);
    }
}
