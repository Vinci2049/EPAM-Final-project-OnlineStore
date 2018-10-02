package com.epam.training.onlineStore.service;

import java.util.List;

import com.epam.training.onlineStore.model.Order;

public interface OrderService {

	List<Order> getAll();
	
	Order findById (long id);	

	long add(Order order);
	
	long setPaidById(long orderId, boolean isPaid);

	//Order fillFromCart(User user);
	
}
