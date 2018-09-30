package com.epam.training.onlineStore.service;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityService<T extends Serializable> {

	List<T> getAll();
	
	T findById (long id);	
	
	//long add(T t);
	
}
