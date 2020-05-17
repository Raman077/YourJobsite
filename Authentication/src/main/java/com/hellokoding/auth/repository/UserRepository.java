package com.hellokoding.auth.repository;
import org.springframework.data.domain.Sort;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(String id);
    User findByCompany(Company company, Sort sort);
}
