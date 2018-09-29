package com.epam.training.onlineStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.onlineStore.dto.ProductDAO;
import com.epam.training.onlineStore.model.Product;
import com.epam.training.onlineStore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDAO productDAO;
	
	@Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
	
	@Override
	public List<Product> getAll() {
        return this.productDAO.getAll();
	}

	@Override
	public Product findById(long id) {
		return this.productDAO.findById(id);
	}

	@Override
	public long add(Product product) {
		return this.productDAO.add(product);
	}

	@Override
	public long edit(Product product) {
		return this.productDAO.edit(product);
	}

}
