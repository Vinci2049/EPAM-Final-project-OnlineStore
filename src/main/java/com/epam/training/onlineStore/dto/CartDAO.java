package com.epam.training.onlineStore.dto;

import java.util.List;

import com.epam.training.onlineStore.model.Cart;

public interface CartDAO {

	List<Cart> getAll();
	//long add(Cart cart);

	
	Cart findById(long idUser);
	
	//List<ProductListItem> getProductList(long idClient);
	
	int addProductById(long idUser, long idProduct);
	
	int removeProductById(long idUser, long idProduct);
}
