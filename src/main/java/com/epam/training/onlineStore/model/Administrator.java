package com.epam.training.onlineStore.model;

import com.epam.training.onlineStore.OnlineStoreApplication;

public class Administrator extends User {

	public Administrator(int id, String name, String surname, com.epam.training.onlineStore.dto.impl.User.rights rights) {
		super(id, name, surname, rights);
	}

}
