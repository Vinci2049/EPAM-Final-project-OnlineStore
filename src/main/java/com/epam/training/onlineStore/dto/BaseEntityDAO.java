package com.epam.training.onlineStore.dto;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityDAO<T extends Serializable> {

	List<T> getAll();
	T findById(long id);

	long add(T t);
}
