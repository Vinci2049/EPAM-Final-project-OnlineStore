package com.epam.training.onlineStore.dto;

import com.epam.training.onlineStore.model.User;

public interface UserDAO extends BaseEntityDAO <User> {

	User findByLogin(String login);

	public long edit(User user);

	public long deleteById(long id);	
	
}
