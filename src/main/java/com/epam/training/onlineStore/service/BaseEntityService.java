package com.epam.training.onlineStore.service;

import java.io.Serializable;
import java.util.List;

import com.epam.training.onlineStore.model.Product;

public interface BaseEntityService<T extends Serializable> {

	List<T> getAll();
	T findById (long id);
	
	
	//long add(T t);
	
}
