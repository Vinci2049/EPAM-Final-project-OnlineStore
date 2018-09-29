package com.epam.training.onlineStore.dto;

import com.epam.training.onlineStore.model.Product;

public interface ProductDAO extends BaseEntityDAO <Product> {
	
	public long edit(Product product);
	
}
