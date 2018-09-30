package com.epam.training.onlineStore.dto;

import com.epam.training.onlineStore.model.Order;

public interface OrderDAO extends BaseEntityDAO <Order> {
	

	long add(Order order);

	long edit(Order order);
	
	long deleteById(long id);
	
}
