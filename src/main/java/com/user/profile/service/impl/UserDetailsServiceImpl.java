package com.user.profile.service.impl;

import com.user.profile.model.Company;
import lombok.Data;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.user.profile.repo.UserRepo;
import com.user.profile.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.disabled(false);
            builder.authorities("ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();  }
    }


