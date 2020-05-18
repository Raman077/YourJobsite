package com.user.profile.repo;

import com.user.profile.model.User;

public interface UserRepoCustom {
  User getUserByUsername(String username);
}
