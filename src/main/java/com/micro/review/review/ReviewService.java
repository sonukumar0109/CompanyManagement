package com.micro.review.review;

import java.util.List;

public interface ReviewService {

    List<Reviews> getAllReviews(Long companyId);
    void createReviewForCompany(Long companyId,Reviews reviews);
    Reviews getReviewByReviewId(Long reviewId);
    void deleteReviewByReviewId(Long reviewId);
    void updateReviewByReviewId(Long reviewId,Reviews reviews);
}
