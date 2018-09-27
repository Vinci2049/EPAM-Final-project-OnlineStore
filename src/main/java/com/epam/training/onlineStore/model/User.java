package com.epam.training.onlineStore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User extends NamedEntity {

    @NotEmpty(message="Логин должен быть заполнен")
    @Size(min = 3, message="Логин должен быть длиннее 3")
    private long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Permissions role;

    /*public User(int id, String name, String surname) {
    	this.setId(id);
    	this.setName(name);
    	this.setSurname(surname);
        //super();
        // TODO Auto-generated constructor stub
    }*/
        
	public User() {
	
	}
    
    public User(
			@NotEmpty(message = "Логин должен быть заполнен") @Size(min = 3, message = "Логин должен быть длиннее 3") long id,
			String login, String password, String name, String surname, String email, Permissions role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.role = role;
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

    public Permissions getRole() {
        return role;
    }

    public void setRole(Permissions role) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
