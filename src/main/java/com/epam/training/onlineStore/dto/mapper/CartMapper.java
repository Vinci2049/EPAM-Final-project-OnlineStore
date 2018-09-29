package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;

public class CartMapper implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//User client = new User(1, "Name", "Surname");		
		User client = new User();		
		
		List<ProductListItem> productList = new ArrayList<>();
			
		Cart cart = new Cart(client, new Date(), productList);
		
		return cart;
	}
	
	

	
	/*public final static RowMapper<Cart> orderMapper = ParameterizedBeanPropertyRowMapper.newInstance(Cart.class);
	
	public final static RowMapper<ProductListItem> lineItemMapper = ParameterizedBeanPropertyRowMapper.newInstance(ProductListItem.class);	
	
	
	public Order findOrderWithItems(Long orderId) {
	    return jdbcTemplate.query("select * from orders, line_item "
	            + " where orders.order_id = line_item.order_id and orders.order_id = ?", 
	            new ResultSetExtractor<Order>() {
	        public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
	            Order order = null;
	            int row = 0;
	            while (rs.next()) {
	                if (order == null) {
	                    order = orderMapper.mapRow(rs, row);
	                }
	                order.addItem(lineItemMapper.mapRow(rs, row));
	                row++;
	            }
	            return order;
	        }

	    }, orderId);
	}

	public List<Order> findAllOrderWithItmes() {
	    return jdbcTemplate.query("select * from orders, line_item "
	            + " where orders.order_id = line_item.order_id order by orders.order_id",
	            new ResultSetExtractor<List<Order>>() {
	                public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
	                    List<Order> orders = new ArrayList<Order>();
	                    Long orderId = null;
	                    Order currentOrder = null;
	                    int orderIdx = 0;
	                    int itemIdx = 0;
	                    while (rs.next()) {
	                        // first row or when order changes
	                        if (currentOrder == null || !orderId.equals(rs.getLong("order_id"))) {
	                            orderId = rs.getLong("order_id");
	                            currentOrder = orderMapper.mapRow(rs, orderIdx++);
	                            itemIdx = 0;
	                            orders.add(currentOrder);
	                        }
	                        currentOrder.addItem(lineItemMapper.mapRow(rs, itemIdx++));
	                    }
	                    return orders;
	                }

	            });
	}*/
	
}
