package com.manoj.springsecurity.dto;

import java.util.Arrays;

public enum SocialProvider {

    FACEBOOK("facebook"), TWITTER("twitter"), LINKEDIN("linkedin"), GOOGLE("google"), GITHUB("github"), LOCAL("local"), UNKNOWN("unknown");

    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    SocialProvider(final String providerType) {
        this.providerType = providerType;
    }

    public static SocialProvider getValue(String providerType){
      return  Arrays.stream( SocialProvider.values() ).filter( sp->sp.getProviderType().equalsIgnoreCase( providerType ) ).findFirst().orElse(UNKNOWN  );
    }

}
