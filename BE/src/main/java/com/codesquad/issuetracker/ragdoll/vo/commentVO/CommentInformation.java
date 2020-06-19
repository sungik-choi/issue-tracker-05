package com.codesquad.issuetracker.ragdoll.vo.commentVO;

import java.util.List;

public class CommentInformation {

    private int countOfComment;

    private List<CommentDetails> comments;

    private CommentInformation(int countOfComment, List<CommentDetails> comments) {
        this.countOfComment = countOfComment;
        this.comments = comments;
    }

    public static CommentInformation of(int countOfComment, List<CommentDetails> comments) {
        return new CommentInformation(countOfComment, comments);
    }

    public int getCountOfComment() {
        return countOfComment;
    }

    public List<CommentDetails> getComments() {
        return comments;
    }
}
