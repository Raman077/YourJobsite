package com.user.profile.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}