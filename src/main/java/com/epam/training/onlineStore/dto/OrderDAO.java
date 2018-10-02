package com.epam.training.onlineStore.dto;

import java.util.List;

import com.epam.training.onlineStore.model.Order;

public interface OrderDAO {

	List<Order> getAll();

	long add(Order order);
	
	
	Order findById(long orderId);

	//Order fillFromCart(User user);
	
	long setPaidById(long orderId, boolean isPaid);
	
}
