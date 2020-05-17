package com.user.profile.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.profile.model.User;
import com.user.profile.repo.UserRepo;
import com.user.profile.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override public User createUser (User user){
      return userRepo.save(user);
    }

    @Override public User getUser (Long id){
      Optional<User> user = userRepo.findById(id);
      return user.map(usr -> usr).orElse(null);
    }

    @Override public List<User> listUsers () {
      return userRepo.findAll();
    }
}
