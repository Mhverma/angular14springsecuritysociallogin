package com.manoj.springsecurity.security.oauth2.user;

import com.manoj.springsecurity.dto.SocialProvider;
import com.manoj.springsecurity.exceptions.OAuth2AuthenticationProcessingException;

import java.util.Locale;
import java.util.Map;

public class OAuth2UserInfoFactory {


    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {

        OAuth2UserInfo userInfo = null;

        SocialProvider provider = SocialProvider.getValue( registrationId.toLowerCase( ) );
        switch (provider) {
            case TWITTER:
            case GITHUB:
                userInfo =  new GithubOAuth2UserInfo( attributes );
                break;
            case FACEBOOK:
                userInfo =new FacebookOAuth2UserInfo( attributes );
                break;
            case GOOGLE:
                userInfo = new GoogleOAuth2UserInfo( attributes );
                break;
            case UNKNOWN:
                throw new OAuth2AuthenticationProcessingException( "Sorry! Login with " + registrationId + " is not supported yet.");

        }
        return userInfo;
    }

    }
