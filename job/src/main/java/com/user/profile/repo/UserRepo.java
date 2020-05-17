package com.user.profile.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.user.profile.model.User;

public interface UserRepo extends CrudRepository<User,Long> {

  User save(User user);

  List<User> findAll();

  Optional<User> findById(Long id);
  User findByUsername(String username);

}
