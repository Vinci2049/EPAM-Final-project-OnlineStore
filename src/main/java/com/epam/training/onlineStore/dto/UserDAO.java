package com.epam.training.onlineStore.dto;

import java.util.List;

import com.epam.training.onlineStore.model.User;

public interface UserDAO {

	List<User> getAll();
	User findById(long userId);

	long add(User user);	
	
	User findByLogin(String login);

	public long edit(User user);

	public long deleteById(long id);	
	
}
