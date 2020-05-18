package com.user.profile.service;

import com.user.profile.model.Company;

public interface CompanyService {
  Company getCompany(Long id);

  Long incrementViews(Long id);
}
