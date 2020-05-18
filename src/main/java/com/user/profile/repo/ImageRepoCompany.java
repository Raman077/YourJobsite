package com.user.profile.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.user.profile.model.User;
import com.user.profile.model.Company;
public interface ImageRepoCompany extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
}