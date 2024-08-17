package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    // Find all replies for a specific review
    List<Comment> findByReviewId(Long reviewId);

    List<Comment> findByCommentKeywordsContaining(String keyword);
}
