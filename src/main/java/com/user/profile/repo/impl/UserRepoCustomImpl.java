package com.user.profile.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.user.profile.model.User;
import com.user.profile.repo.UserRepoCustom;

@Repository
public class UserRepoCustomImpl implements UserRepoCustom {

  @PersistenceContext
  EntityManager entityManager;


  @Override
  public User getUserByUsername(String name) {
    Query query = entityManager.createQuery("SELECT usr FROM User usr WHERE usr.username = :userName ");
    query.setParameter("userName", name);
    List user = query.getResultList();
    return user.isEmpty()?null:(User) user.get(0);
  }
}
