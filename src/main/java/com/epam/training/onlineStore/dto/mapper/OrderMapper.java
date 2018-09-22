package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.Client;
import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.model.Product;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//super(id, name, surname, rights);
//		Client client = new Client(
//				rs.getInt("Client_idClient"),
//				rs.getString("Client_name"),
//				rs.getString("Client_surname"),
//				com.epam.training.onlineStore.dto.impl.User.rights.client);
		Client client = new Client(
				rs.getInt("Client_idClient"),
				rs.getString("Client_name"),
				rs.getString("Client_surname"));
		
		
		Order order = new Order();
		/*Order order = new Order(
				rs.getInt("id"),
				rs.getDate("date"),
				client);*/
		
		return order;
		
//		Customer customer = new Customer();
//	    customer.setId(resultSet.getInt("customer_id"));
//	    customer.setEmail(resultSet.getString("email"));
//	 
//	    Order order = new Order();
//	    order.setId(resultSet.getInt("id"));
//	    order.setCustomer(customer);
		
	}

}
