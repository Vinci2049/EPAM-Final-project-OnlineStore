package com.epam.training.onlineStore.dto.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.OrderDAO;
import com.epam.training.onlineStore.dto.mapper.OrderListMapper;
import com.epam.training.onlineStore.dto.mapper.OrderMapper;
import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.model.ProductListItem;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	@Override
	public List<Order> getAll() {
		
		return this.jdbcTemplate.query("Select * from " + 
				"(select * from clientorder join user on user_id = userId) User " + 
				"join " + 
				"(select * from clientorderproductlist join product on product_idProduct = productId) Product " + 
				"on ClientOrderId = ClientOrder_ClientOrderId order by ClientOrderId",
                new OrderListMapper());
	}

	@Override
	public Order findById(long orderId) {
		
		Order order = this.jdbcTemplate.query("Select * from " + 
				"(select * from clientorder join user on user_id = userId) User " + 
				"join " + 
				"(select * from clientorderproductlist join product on product_idProduct = productId) Product " + 
				"on ClientOrderId = ClientOrder_ClientOrderId where ClientOrderId = ?",
                new Object[]{orderId}, new OrderMapper());
		
		return order;
	}

	
	@Override
	public long add(Order order) {


		final String INSERT_SQL = "INSERT INTO ClientOrder (User_id, date, cost, isPaid) VALUES (?, ?, ?, ?);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(
			    new PreparedStatementCreator() {
			    	@Override
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(INSERT_SQL, new String[] {"ClientOrderId"});
			            ps.setLong(1, order.getUser().getId());
			            ps.setDate(2, new java.sql.Date(order.getDate().getTime()));
			            ps.setDouble(3, order.getCost());
			            ps.setBoolean(4, order.getIsPaid());
			            return ps;
			        }
			    },
			    keyHolder);		
		 
		final long newId = keyHolder.getKey().longValue();

		if (order != null && order.getProductList() != null) {
		
			for (ProductListItem productListItem : order.getProductList()) {
				this.jdbcTemplate.update("INSERT INTO ClientOrderProductList (ClientOrder_ClientOrderId,"
					+ " product_idProduct, quantity) VALUES"
					+ "(?,?,?)"
					, newId
	        		, productListItem.getProduct().getId()
	        		, productListItem.getQuantity());
			}
		}

		return 1;
	}

	
	@Override
	public long setPaidById(long orderId, boolean isPaid) {
		return this.jdbcTemplate.update("UPDATE CLIENTORDER SET isPaid = ? WHERE ClientOrderId = ?"
                , !isPaid
				, orderId);
	}
	
}
