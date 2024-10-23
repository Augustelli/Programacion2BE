package com.programacion2.mancusoaugusto.web.rest.dto.request;

public class AutenticarUsuarioCatedra {
    private String username;
    private String password;
    private Boolean rememberMe;

    public AutenticarUsuarioCatedra() {
        this.username = "Augustelli";
        this.password = "admin";
        this.rememberMe = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
