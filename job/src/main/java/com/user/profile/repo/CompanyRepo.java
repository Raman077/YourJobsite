package com.user.profile.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.user.profile.model.Company;

public interface CompanyRepo extends CrudRepository<Company, Long> {
  Company save(Company company);

  List<Company> findAll();

  Optional<Company> findById(Long id);

}
