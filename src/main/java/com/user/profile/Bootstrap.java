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
//    company.setName("ZestMoney");
//    companyRepo.save(company);
//    Company company1 = new Company();
//    company1.setName("amazon");
//    companyRepo.save(company1);
//    System.out.println("Companies saved!!");
////    User user = new User();
////    user.setName("Raman");
////    user.setCompanyId(new Long(1));
////    user.setJobRole("SDE");
////    user.setUsername("Ray-Man");
////    user.setPassword("ramani");
//    List<Company> companyList = companyRepo.findAll();
////
//////    User usr = userRepo.save(user);
//
//    companyList =

//    User test = userRepo.getUserByUsername("Ray-Man");
    System.out.println(companyRepo.findAll());

  }
}
