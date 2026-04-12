package com.micro.company.company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    void updateCompanyById(Long id,Company company);
    void deleteCompanyById(Long id);
}
