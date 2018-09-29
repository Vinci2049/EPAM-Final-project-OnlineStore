package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//User client = new User(1, "Name", "Surname");		
		User client = new User();		
		
		List<ProductListItem> productList = new ArrayList<>();
	
		boolean isPaid = false;
			
		Order order = new Order(client, new Date(), productList, isPaid);
		
		return order;
		
		
	}

}
