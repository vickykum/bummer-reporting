package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.dao.CommentDao;
import com.bummer.bummer_reporting.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public Comment createComment(Comment comment) {
        return commentDao.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentDao.findById(id).orElse(null);
    }

    public List<Comment> getCommentsByReviewId(Long reviewId) {
        return commentDao.findByReviewId(reviewId);
    }

    public List<Comment> getCommentsByKeyword(String keyword) {
        return commentDao.findByCommentKeywordsContaining(keyword);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        return commentDao.findById(id)
                .map(comment -> {
                    comment.setCommentType(commentDetails.getCommentType());
                    comment.setCommentBlob(commentDetails.getCommentBlob());
                    comment.setUpvotes(commentDetails.getUpvotes());
                    comment.setDownvotes(commentDetails.getDownvotes());
                    comment.setTimestamp(commentDetails.getTimestamp());
                    comment.setCommentKeywords(commentDetails.getCommentKeywords());
                    comment.setCreatedAt(commentDetails.getCreatedAt());
                    comment.setUpdatedAt(commentDetails.getUpdatedAt());
                    return commentDao.save(comment);
                })
                .orElseGet(() -> {
                    commentDetails.setId(id);
                    return commentDao.save(commentDetails);
                });
    }

    public void deleteComment(Long id) {
        commentDao.deleteById(id);
    }

    public List<Comment> getAllCommentsByReviewId(Long reviewId) {
        return commentDao.findByReviewId(reviewId);
    }
}
