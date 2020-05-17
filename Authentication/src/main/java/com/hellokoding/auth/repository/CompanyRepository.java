package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    Company findById(String id);
    Long save(Company company);
}
