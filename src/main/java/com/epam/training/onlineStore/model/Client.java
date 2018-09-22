package com.epam.training.onlineStore.model;

public class Client extends User{

	//public Client(int id, String name, String surname, com.epam.training.onlineStore.dto.impl.User.rights rights) {
	//	super(id, name, surname, rights);
	public Client(int id, String name, String surname) {
		super(id, name, surname);
	}

	public boolean registerOrder() {

		return true;
	}
	
	public boolean paidOrder() {
		
		return true;
	}

}
