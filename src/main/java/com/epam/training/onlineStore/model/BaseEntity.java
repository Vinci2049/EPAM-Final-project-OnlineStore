package com.epam.training.onlineStore.model;

import java.io.Serializable;

//@MappedSuperclass
public class BaseEntity implements Serializable {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isNew() {
		//return this.id == null;
		return (Long) this.id == null;
	}
}
