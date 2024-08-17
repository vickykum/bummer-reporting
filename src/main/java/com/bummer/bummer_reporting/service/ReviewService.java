package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.dao.ReviewDao;
import com.bummer.bummer_reporting.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    public Review createReview(Review review) {
        return reviewDao.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewDao.findById(id).orElse(null);
    }

    public List<Review> getReviewsByRestaurantId(Long restaurantId) {
        return reviewDao.findReviewsByRestaurantId(restaurantId);
    }

    public List<Review> getReviewsByKeyword(String keyword) {
        return reviewDao.findByReviewKeywordsContaining(keyword);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        return reviewDao.findById(id)
                .map(review -> {
                    review.setReviewBlob(reviewDetails.getReviewBlob());
                    review.setUpvotes(reviewDetails.getUpvotes());
                    review.setDownvotes(reviewDetails.getDownvotes());
                    review.setReport(reviewDetails.getReport());
                    review.setTimestamp(reviewDetails.getTimestamp());
                    review.setReviewKeywords(reviewDetails.getReviewKeywords());
                    review.setReportingTimestamp(reviewDetails.getReportingTimestamp());
                    review.setTotalComments(reviewDetails.getTotalComments());
                    return reviewDao.save(review);
                })
                .orElseGet(() -> {
                    reviewDetails.setId(id);
                    return reviewDao.save(reviewDetails);
                });
    }

    public void deleteReview(Long id) {
        reviewDao.deleteById(id);
    }

    public List<Review> getAllReviewsByRestaurantId(Long restaurantId) {
        return reviewDao.findReviewsByRestaurantId(restaurantId);
    }
}
