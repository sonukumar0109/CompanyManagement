package com.micro.jobs.job.clients;

import com.micro.jobs.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY")
public interface CompanyClient {
    @GetMapping("/Company/{id}")
    Company getCompany(@PathVariable("id") Long id);
}
