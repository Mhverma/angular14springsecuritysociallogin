package com.manoj.springsecurity.service;

import com.manoj.springsecurity.dto.LocalUser;
import com.manoj.springsecurity.dto.SignUpRequest;
import com.manoj.springsecurity.exceptions.UserAlreadyExistAuthenticationException;
import com.manoj.springsecurity.model.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

public interface UserService {

    public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}


