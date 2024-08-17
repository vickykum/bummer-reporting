package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

    List<Review> findReviewsByRestaurantId(Long restaurantId);

    List<Review> findByReviewKeywordsContaining(String keyword);

    Review findReviewById(Long reviewId);
}
