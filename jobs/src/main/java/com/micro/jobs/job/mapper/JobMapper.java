package com.micro.jobs.job.mapper;

import com.micro.jobs.job.Job;
import com.micro.jobs.job.dto.JobDTO;
import com.micro.jobs.job.external.Company;
import com.micro.jobs.job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review>reviewList){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSal(job.getMaxSal());
        jobDTO.setMinSal(job.getMinSal());
        jobDTO.setCompany(company);
        jobDTO.setReview(reviewList);
        return jobDTO;
    }
}
