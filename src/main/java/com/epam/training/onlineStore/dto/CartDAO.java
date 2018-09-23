package com.epam.training.onlineStore.dto;

import com.epam.training.onlineStore.model.Cart;

public interface CartDAO {

	Cart findById(long idClient);
	
	//List<ProductListItem> getProductList(long idClient);
	
	int addProductById(long idProduct);
	
	int removeProductById(long idProduct);
}
