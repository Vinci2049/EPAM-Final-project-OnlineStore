package com.epam.training.onlineStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.onlineStore.dto.OrderDAO;
import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderDAO orderDAO;
	
	@Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
		
	@Override
	public List<Order> getAll() {
		return this.orderDAO.getAll();
	}

	@Override
	public Order findById(long id) {
		return this.orderDAO.findById(id);
	}
	
	@Override
	public long add(Order order) {
		return this.orderDAO.add(order);
	}

	@Override
	public long setPaidById(long orderId, boolean isPaid) {
		return this.orderDAO.setPaidById(orderId, isPaid);
	}	
	
//	@Override
//	public long fillFromCart(User user) {
//		return this.orderDAO.fillFromCart(user);
//	}	
	
	
}
