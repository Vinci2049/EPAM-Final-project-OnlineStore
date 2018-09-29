package com.epam.training.onlineStore.service;

import com.epam.training.onlineStore.model.Product;

public interface ProductService extends BaseEntityService<Product>{

	long add(Product product);

	long edit(Product product);
	
	long deleteById(long id);
	
}
