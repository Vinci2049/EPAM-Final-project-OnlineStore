package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.Product;
import com.epam.training.onlineStore.model.ProductListItem;

public class ProductListItemMapper implements RowMapper<ProductListItem> {

	@Override
	public ProductListItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductMapper productMapper = new ProductMapper();
		
		Product product = productMapper.mapRow(rs, rowNum);
		
		ProductListItem productListItem = new ProductListItem(
				product,
				rs.getFloat("Quantity"));
		
		return productListItem;
	}
	
	
}
