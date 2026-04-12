package com.micro.jobs.job.impl;
import com.micro.jobs.job.Job;
import com.micro.jobs.job.JobRepository;
import com.micro.jobs.job.JobService;
import com.micro.jobs.job.clients.CompanyClient;
import com.micro.jobs.job.clients.ReviewClient;
import com.micro.jobs.job.dto.JobDTO;
import com.micro.jobs.job.external.Company;
import com.micro.jobs.job.external.Review;
import com.micro.jobs.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job>jobs = new ArrayList<>();

    JobRepository jobRepository ;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;

    private  ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient=reviewClient;
    }

    private Long nextId = 1L;

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();
        //RestTemplate restTemplate = new RestTemplate();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job){
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review>reviewList = reviewClient.getReview(job.getCompanyId());
        JobDTO jobDTO = JobMapper.mapToJobWithCompanyDTO(job,company,reviewList);
        return jobDTO;
    }

    @Override
    public void createJobs(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id){
        Job job =  jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }
    @Override
    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    @Override
    public void updateJobById(Long id,Job job){
        Optional<Job>optionalJob = jobRepository.findById(id);

        if(optionalJob.isPresent()) {
            Job job1 = optionalJob.get();
            job1.setDescription(job.getDescription());
            job1.setTitle(job.getTitle());
            job1.setLocation(job.getLocation());
            job1.setMinSal(job.getMinSal());
            job1.setMaxSal(job.getMaxSal());
            jobRepository.save(job1);
        }
    }
}
