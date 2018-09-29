package com.epam.training.onlineStore.dto;

import com.epam.training.onlineStore.model.User;

public interface UserDAO extends BaseEntityDAO <User> {

	User findByLogin(String login);
	
}
