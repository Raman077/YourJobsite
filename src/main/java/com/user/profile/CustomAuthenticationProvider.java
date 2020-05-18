package com.user.profile;


import java.util.Collections;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
  @Override
  public Authentication authenticate(Authentication authentication) {
    String username = authentication.getName();

    String password = authentication.getCredentials().toString();
     return new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());

  }
  @Override
  public boolean supports(Class<?>aClass) {
    return aClass.equals(UsernamePasswordAuthenticationToken.class);
  }
}
