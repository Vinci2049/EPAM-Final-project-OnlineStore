package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;

public class CartMapper implements ResultSetExtractor<Cart>{		

	@Override
	public Cart extractData(ResultSet rs) throws SQLException, DataAccessException {

		Cart cart = null;
		
		boolean isFirstRow = true;
		
		User user = null;
		Date date = null;
		List<ProductListItem> productList = new ArrayList<>();
		
        while (rs.next()) {
        	
        	if (isFirstRow) {
         		UserMapper userMapper = new UserMapper();
        		user = userMapper.mapRow(rs, 0);
        		date = rs.getDate("date");
        		isFirstRow = false;
        	}
        	
        	ProductListItemMapper productListItemMapper = new ProductListItemMapper();
        	ProductListItem productListItem = productListItemMapper.mapRow(rs, 0);
        	productList.add(productListItem);
        	        	
        }
        
        //if (user != null) {
        	cart = new Cart(user, date, productList);
        //}
        	
        return cart;
		
	}
		
}
