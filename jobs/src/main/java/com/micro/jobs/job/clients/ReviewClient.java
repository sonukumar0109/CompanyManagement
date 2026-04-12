package com.micro.jobs.job.clients;

import com.micro.jobs.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW")
public interface ReviewClient {
    @GetMapping("/review")
    List<Review> getReview(@RequestParam("companyId") Long companyId);
}
