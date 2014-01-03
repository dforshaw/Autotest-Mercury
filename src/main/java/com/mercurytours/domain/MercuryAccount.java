package com.mercurytours.domain;

/**
 * Mercury Tours Domain Info
 */

public class MercuryAccount {
    private static final String MERCURY_USERNAME_KEY = "MERCURY_USERNAME";
    private static final String MERCURY_PASSWORD_KEY = "MERCURY_PASSWORD";
    private static final String MERCURY_URL_KEY = "MERCURY_URL";

    public final String userName;
    public final String password;
    public final String mercury_url;

    public MercuryAccount(){
        userName = System.getProperty(MERCURY_USERNAME_KEY, "bsmith");
        password = System.getProperty(MERCURY_PASSWORD_KEY, "password");
        mercury_url = System.getProperty(MERCURY_URL_KEY, "http://newtours.demoaut.com");
    }
}
