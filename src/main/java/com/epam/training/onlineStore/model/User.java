package com.epam.training.onlineStore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message="Логин должен быть заполнен")
    @Size(min = 3, message="Логин должен быть длиннее 3")
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String role;

    public User(int id, String name, String surname) {
    	this.setId(id);
    	this.setName(name);
    	this.setSurname(surname);
        //super();
        // TODO Auto-generated constructor stub
    }

    public User(String login) {
        super();
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
