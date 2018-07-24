package com.demo.jaden.employapplication.objectbox.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class JobEntiey {
    @Id
    Long Id;

    String companyId;

    String requirements;

    String address;

    String salaryRange;

    public JobEntiey(String companyId, String requirements, String address, String salaryRange) {

        this.companyId = companyId;
        this.requirements = requirements;
        this.address = address;
        this.salaryRange = salaryRange;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
}
