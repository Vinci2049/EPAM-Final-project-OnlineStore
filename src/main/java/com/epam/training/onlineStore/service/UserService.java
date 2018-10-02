package com.epam.training.onlineStore.service;

import com.epam.training.onlineStore.model.User;

public interface UserService extends BaseEntityService<User>{

    boolean checkAndAddUser(User user);

    User findUserByLogin(String login);

    User checkLoginAndPasswordAndGetUser(String login, String password);

	long add(User user);

	long edit(User user);
	
	long deleteById(long id);    
    
}
