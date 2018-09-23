package com.epam.training.onlineStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.onlineStore.dto.CartDAO;
import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private final CartDAO cartDAO;
	
	@Autowired
    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }	
	
	@Override
	public Cart findById(long idClient) {
		return this.cartDAO.findById(idClient);
	}
	
	
	@Override
	public void addProductById(long productId) {
		this.cartDAO.addProductById(productId);
	}

	@Override
	public void removeProductById(long productId) {
		this.cartDAO.removeProductById(productId);
		
	}
	
}
