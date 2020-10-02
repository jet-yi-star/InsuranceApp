package com.jet.rest.webservices.restfulwebservices.basic.auth;

public class AuthenticationBean {
    private String message;

    public AuthenticationBean(String hello_world) {
        this.message = hello_world;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
