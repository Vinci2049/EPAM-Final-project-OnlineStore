package com.epam.training.onlineStore.service;

import com.epam.training.onlineStore.model.Order;

public interface OrderService extends BaseEntityService<Order> {

	long add(Order order);

	long edit(Order order);
	
	long deleteById(long id);
	
}
