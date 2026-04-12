package com.micro.review.review.impl;
import com.micro.review.review.ReviewRepository;
import com.micro.review.review.ReviewService;
import com.micro.review.review.Reviews;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;



    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews>reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
    @Override
    public void createReviewForCompany(Long companyId,Reviews reviews) {
        if(companyId!=null){
            reviews.setCompanyId(companyId);
            reviewRepository.save(reviews);
        }

    }

    @Override
    public Reviews getReviewByReviewId(Long reviewId) {
        Reviews reviews = reviewRepository.findById(reviewId).orElse(null);
        return reviews;
    }

    @Override
    public void deleteReviewByReviewId(Long reviewId) {
            Reviews reviews = reviewRepository.findById(reviewId).orElse(null);
            if(reviews!=null){
                reviewRepository.delete(reviews);
            }

    }

    @Override
    public void updateReviewByReviewId(Long reviewId, Reviews reviews) {
        Reviews reviews1 = reviewRepository.findById(reviewId).orElse(null);
        if(reviews1!=null){
            reviews1.setCompanyId(reviews.getCompanyId());
            reviews1.setGrade(reviews.getGrade());
            reviews1.setStar(reviews.getStar());
            reviews1.setRemarks(reviews.getRemarks());
            reviewRepository.save(reviews1);
        }

    }
}
