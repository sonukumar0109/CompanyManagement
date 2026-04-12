package com.micro.review.review;

import jakarta.persistence.*;

@Entity
@Table(name = "review_ms")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String star;
    private String grade;
    private String remarks;
    private Long companyId;

    public Reviews() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Reviews(Long id, String star, String grade, String remarks) {
        this.id = id;
        this.star = star;
        this.grade = grade;
        this.remarks = remarks;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
