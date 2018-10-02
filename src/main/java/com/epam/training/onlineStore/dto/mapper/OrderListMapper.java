package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;

public class OrderListMapper implements ResultSetExtractor<List<Order>>{		

	@Override
	public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Order> orders = new ArrayList<>();
		
		long currentId = 0L;

		Order order = null;
		
		long id = 0L;
		User user = null;
		Date date = null;
		double cost = 0.0;
		boolean isPaid = false;
		
		List<ProductListItem> productList = new ArrayList<>();
		
        while (rs.next()) {
        	
        	id = rs.getLong("ClientOrderId");
        	
        	if (id != currentId) {
        	
                if (user != null) {
                	order = new Order(currentId, user, date, cost, isPaid, productList);
                	orders.add(order);
                }
           		
        		currentId = id;
         		UserMapper userMapper = new UserMapper();
        		user = userMapper.mapRow(rs, 0);
         		date = rs.getDate("date");
        		cost = rs.getDouble("cost");
        		isPaid = rs.getBoolean("isPaid");
        		
        		productList = new ArrayList<>();
       		
        	}
        	
        	ProductListItemMapper productListItemMapper = new ProductListItemMapper();
        	ProductListItem productListItem = productListItemMapper.mapRow(rs, 0);
        	productList.add(productListItem);
        	        	        
        }
        	
        if (user != null) {
        	order = new Order(id, user, date, cost, isPaid, productList);
        	orders.add(order);
        }
        
        return orders;
		
	}	

}
