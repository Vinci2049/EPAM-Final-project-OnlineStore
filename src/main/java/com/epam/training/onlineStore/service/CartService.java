package com.epam.training.onlineStore.service;

import com.epam.training.onlineStore.model.Cart;

public interface CartService {

	Cart findById (long id);

	void addProductById(long userId, long productId);

	void removeProductById(long userId, long productId);	
	
	void clearProductList(long userId);
}
