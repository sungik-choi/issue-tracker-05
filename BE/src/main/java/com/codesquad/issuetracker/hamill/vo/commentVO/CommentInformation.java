package com.codesquad.issuetracker.hamill.vo.commentVO;

import java.util.List;

public class CommentInformation {

    private int countOfComment;

    private List<CommentSummary> comments;

    private CommentInformation(int countOfComment, List<CommentSummary> comments) {
        this.countOfComment = countOfComment;
        this.comments = comments;
    }

    public static CommentInformation of(int countOfComment, List<CommentSummary> comments) {
        return new CommentInformation(countOfComment, comments);
    }

    public int getCountOfComment() {
        return countOfComment;
    }

    public List<CommentSummary> getComments() {
        return comments;
    }
}
