package com.epam.training.onlineStore.dto;

import java.util.List;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.ProductListItem;

public interface CartDAO {

	Cart findById(long idClient);
	
	//List<ProductListItem> getProductList(long idClient);
	
	void addProductById(long idProduct);
	
}
