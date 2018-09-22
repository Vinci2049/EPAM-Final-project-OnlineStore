package com.epam.training.onlineStore.service;

import com.epam.training.onlineStore.model.Cart;

public interface CartService {

	Cart findById (long id);
	//Map<Product, Integer> getProductList(int idClient);

	void addProductById(long id);
	
}
