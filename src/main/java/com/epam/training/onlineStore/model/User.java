package com.epam.training.onlineStore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User extends NamedEntity {

    @NotEmpty(message="Логин должен быть заполнен")
    @Size(min = 3, message="Логин должен быть длиннее 3")
    private String login;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean inBlackList;


	public User() {
	
	}
    
    public User(
			@NotEmpty(message = "Логин должен быть заполнен") @Size(min = 3, message = "Логин должен быть длиннее 3") long id,
			String login, String password, String name, String email, boolean inBlackList, boolean isAdmin) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
		this.inBlackList = inBlackList;
		this.isAdmin = isAdmin;
	}


	/*public User(String login) {
        super();
        this.login = login;
    }*/

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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
