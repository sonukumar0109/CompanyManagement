package com.micro.review.review;

import com.micro.review.messeging.ReviewMessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    private ReviewMessageProducer reviewMessageProducer;

    public ReviewController(ReviewService reviewService, ReviewMessageProducer reviewMessageProducer) {
        this.reviewService = reviewService;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @GetMapping()
    public ResponseEntity<List<Reviews>>getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }

    @PostMapping("/create/{companyId}")
    public  ResponseEntity<String>createReviewForCompany(@PathVariable Long companyId,@RequestBody Reviews reviews){
        reviewService.createReviewForCompany(companyId,reviews);
        reviewMessageProducer.sendMessage(reviews);
        return new ResponseEntity<>( "data saved successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewId}")
    public  ResponseEntity<String>deleteReviewByReviewId(@PathVariable Long reviewId){
        reviewService.deleteReviewByReviewId(reviewId);
        return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public  ResponseEntity<Reviews>getReviewByReviewId(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewByReviewId(reviewId),HttpStatus.OK);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<String>updateReviewByReviewId(@PathVariable Long reviewId,@RequestBody Reviews reviews){
        reviewService.updateReviewByReviewId(reviewId,reviews);
        return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
    }


    @GetMapping("/avarageRating")
    public String getAvgRating(@RequestParam Long companyId){
        List<Reviews>reviewsList = reviewService.getAllReviews(companyId);
        return reviewsList.get(0).getGrade();
    }


}
