package com.manoj.springsecurity.security.oauth2;

import com.manoj.springsecurity.exceptions.OAuth2AuthenticationProcessingException;
import com.manoj.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class CustomOidcUserService extends OidcUserService {
    @Autowired
    private UserService userService;
    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser( userRequest );
        try {
            return userService.processUserRegistration(userRequest.getClientRegistration().getRegistrationId(), oidcUser.getAttributes(), oidcUser.getIdToken(),
                                                       oidcUser.getUserInfo());
        }catch (AuthenticationException ex){
            throw new OAuth2AuthenticationProcessingException( ex.getMessage(), ex.getCause());
        }
    }
}


