package com.epam.training.onlineStore.dto.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.CartDAO;
import com.epam.training.onlineStore.dto.mapper.CartMapper;
import com.epam.training.onlineStore.dto.mapper.ProductMapper;
import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.Product;
import com.epam.training.onlineStore.model.ProductListItem;

@Repository
public class CartDAOImpl implements CartDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	/*@Override
	public Cart findById(long idClient) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM cart WHERE Client_idClient = ?",
                new Object[]{idClient}, new CartMapper());
		//return this.jdbcTemplate.query("SELECT * FROM cart", new CartMapper());
	}*/


	@Override
	public Cart findById(long idClient) {
		//return this.jdbcTemplate.queryForObject("SELECT * FROM cart WHERE Client_idClient = ?",
        //        new Object[]{idClient}, new CartMapper());
		return this.jdbcTemplate.queryForObject("Select * from cart join cartproductlist on client_idClient = cart_client_idClient where client_idClient = ? limit 1",
                new Object[]{idClient}, new CartMapper());
		//return this.jdbcTemplate.query("SELECT * FROM cart", new CartMapper());
	}
	
	
	
	/*@Override
	public void addProductById(long idClient) {
		return this.jdbcTemplate.update("INSERT INTO cart (name, price) VALUES"
	            + "(?,?)"
	          , product.getName()
	          , product.getPrice());
	}*/

	
	
	
//	@Override
//	public List<ProductListItem> getProductList(long idClient) {
//		return this.jdbcTemplate.queryForObject("SELECT * FROM cart WHERE Client_idClient = ?",
//                new Object[]{idClient}, new CartMapper());
//	}

	/*@Override
	public List<ProductListItem> getProductList(long idClient) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM CartProductList WHERE Cart_Client_idClient = ?",
                new Object[]{id}, new CartMapper());
	}*/

	
	
	//public final static RowMapper<Cart> orderMapper = ParameterizedBeanPropertyRowMapper.newInstance(Cart.class);
	
	//public final static RowMapper<ProductListItem> lineItemMapper = ParameterizedBeanPropertyRowMapper.newInstance(ProductListItem.class);	
	
	
	/*public Cart findCartWithItems(Long orderId) {
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
