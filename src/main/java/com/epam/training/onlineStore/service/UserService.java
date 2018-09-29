package com.epam.training.onlineStore.service;

import java.util.List;

import com.epam.training.onlineStore.model.User;


public interface UserService extends BaseEntityService<User>{

    boolean checkAndAddUser(User user);

    //long deleteUser(long id);

    //List<User> getUsers();

    //User getUserById(long id);

    //long setUser(long id, User user);

    User findUserByLogin(String login);

    //boolean checkAndUpdateUser(User user) throws Error;

    User checkLoginAndPasswordAndGetUser(String login, String password);
	
}
