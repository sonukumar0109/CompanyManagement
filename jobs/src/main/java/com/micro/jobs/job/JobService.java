package com.micro.jobs.job;


import com.micro.jobs.job.dto.JobDTO;

import java.util.List;


public interface JobService {
    List<JobDTO>findAll();
    void createJobs(Job job);
    JobDTO getJobById(Long id);
    void deleteJobById(Long id);
    void updateJobById(Long id,Job job);
}
