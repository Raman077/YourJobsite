package com.user.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.user.profile.model.Company;
import com.user.profile.model.User;
import com.user.profile.repo.CompanyRepo;
import com.user.profile.repo.UserRepo;

@Component
public class Bootstrap implements CommandLineRunner {
  @Autowired
  private CompanyRepo companyRepo;

  @Autowired
  private UserRepo userRepo;

  @Override
  public void run(String... args) throws Exception {
    Company company = new Company();
    company.setName("zestMoney");
    companyRepo.save(company);
    Company company1 = new Company();
    company1.setName("amazon");
    companyRepo.save(company1);
    System.out.println("Companies saved!!");
    User user = new User();
    user.setCompanyId((long) 1);
    user.setJobRole("SDE");
    user.setName("Ray-Man");
    List<Company> companyList = companyRepo.findAll();

    userRepo.save(user);

    companyList = companyRepo.findAll();
    System.out.println(companyList);



  }
}
