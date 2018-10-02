package com.epam.training.onlineStore.dto.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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

import com.mysql.jdbc.Statement;

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
				"on ClientOrderId = ClientOrder_ClientOrderId",
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

		// ВРЕМЕННО ОБРАБАТЫВАТЬ 2 РЕЗУЛЬТАТА ???
		
		
		
		final String INSERT_SQL = "INSERT INTO ClientOrder (User_id, date, cost, isPaid) VALUES (?, ?, ?, ?);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(
			    new PreparedStatementCreator() {
			    	@Override
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(INSERT_SQL, new String[] {"ClientOrderId"});
			            ps.setLong(1, 1);
			            ps.setDate(2, new java.sql.Date(order.getDate().getTime()));
			            ps.setDouble(3, order.getCost());
			            ps.setBoolean(4, order.getIsPaid());
			            return ps;
			        }
			    },
			    keyHolder);
			
//			return keyHolder.getKey().intValue();
//
//		.jdbcTemplate.update("INSERT INTO ClientOrder (User_id, date, cost, isPaid) VALUES Statement.RETURN_GENERATED_KEYS"
//		        + "(?,?,?,?)"
//		      ,1 //, order.getUser().getId()
//		      , order.getDate()
//		      , order.getCost()
//		      , order.getIsPaid()
//		      ,keyHolder
//		      ,new String[] {"ClientOrderId"});
		
		 
		final long newId = keyHolder.getKey().longValue();
		System.out.println(newId);


//		this.jdbcTemplate.update("INSERT INTO ClientOrder (User_id, date, cost, isPaid) VALUES Statement.RETURN_GENERATED_KEYS"
//		        + "(?,?,?,?)"
//		      ,1 //, order.getUser().getId()
//		      , order.getDate()
//		      , order.getCost()
//		      , order.getIsPaid()
//		      ,keyHolder
//		      ,new String[] {"ClientOrderId"});
//		
//		 
//		final long newId = keyHolder.getKey().longValue();
//		System.out.println(newId);
		
		
		
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
		// ЧЕГО-ТО ВОЗВРАЩАТЬ ПО РЕЗУЛЬТАТУ ???		
		return 1;

	}

	
	@Override
	public long setPaidById(long orderId, boolean isPaid) {
		return this.jdbcTemplate.update("UPDATE CLIENTORDER SET isPaid = ? WHERE id = ?"
                , isPaid
				, orderId);
		
	}


	/*public final static RowMapper<Order> orderMapper = BeanPropertyRowMapper.newInstance(Order.class);
	public final static RowMapper<ProductListItem> lineItemMapper = BeanPropertyRowMapper.newInstance(ProductListItem.class);

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
