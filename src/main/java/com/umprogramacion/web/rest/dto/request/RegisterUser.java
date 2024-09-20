package com.umprogramacion.web.rest.dto.request;

public class RegisterUser {

    private String login;
    private String email;
    private String password;
    private String langKey = "es";
    private String nombres;
    private String descripcion;

    public RegisterUser(String login, String email, String password, String langKey, String nombres, String descripcion) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.langKey = langKey;
        this.nombres = nombres;
        this.descripcion = descripcion;
    }

    public RegisterUser() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
