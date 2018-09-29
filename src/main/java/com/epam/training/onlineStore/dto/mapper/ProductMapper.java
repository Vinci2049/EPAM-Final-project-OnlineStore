package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getDouble("price"),
				rs.getString("description"));
				
		return product;
	}
	
}
