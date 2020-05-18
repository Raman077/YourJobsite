package com.user.profile.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.profile.model.Company;
import com.user.profile.repo.CompanyRepo;
import com.user.profile.service.CompanyService;
import org.springframework.stereotype.Service;


@Service
public class CompanyServiceImpl implements CompanyService {
  @Autowired
  private CompanyRepo companyRepo;

  @Override
  public Company getCompany(Long id) {
    Optional<Company> company = companyRepo.findById(id);
    return company.map(comp->comp).orElse(null);
  }

  @Override
  public Long incrementViews(Long id) {
    Company company = getCompany(id);
    Long views = company.getViews();
    if(views == null) {
      views = Long.valueOf(0);
    }
    views = views +1;
    company.setViews(views);
    return companyRepo.save(company).getViews();
  }
}
