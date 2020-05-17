package com.user.profile.service;

import java.util.List;

import com.user.profile.model.User;

public interface UserService {
  User createUser(User user);

  User getUser(Long id);

  List<User> listUsers();
}
