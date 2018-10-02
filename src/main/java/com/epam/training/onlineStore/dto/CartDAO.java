package com.epam.training.onlineStore.dto;

import java.util.List;

import com.epam.training.onlineStore.model.Cart;

public interface CartDAO {

	List<Cart> getAll();
	
	Cart findById(long userId);
	
	int addProductById(long userId, long productId);
	
	int removeProductById(long userId, long productId);
	
	int clearProductList(long userId);
	
}
