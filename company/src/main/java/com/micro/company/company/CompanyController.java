package com.micro.company.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompany(){
        return ResponseEntity.ok(companyService.getAllCompany());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company>getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
        @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String>createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String>updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompanyById(id,company);
        return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
    }

}
