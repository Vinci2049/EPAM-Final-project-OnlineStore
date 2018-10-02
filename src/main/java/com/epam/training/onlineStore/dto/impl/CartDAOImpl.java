package com.epam.training.onlineStore.dto.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.CartDAO;
import com.epam.training.onlineStore.dto.mapper.CartMapper;
import com.epam.training.onlineStore.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    	
	@Override
	public Cart findById(long idUser) {
				
		Cart cart  = this.jdbcTemplate.query("Select * from " + 
				"(select * from cart join user on user_id = userId) User " + 
				"join " + 
				"(select * from cartproductlist join product on product_idProduct = productId) Product " + 
				"on user_id = cart_user_id where user_id = ?",
                new Object[]{idUser}, new CartMapper());

		return cart;
			  
	}
	
	
	@Override
	public int addProductById(long idUser, long idProduct) {

		// ВРЕМЕННО !!! ТУТ ПРОВЕРИТЬ ДВА РЕЗУЛЬТАТА НАДО НАВЕРНОЕ
		// ON Duplicate key - правильно ли в первом выражении ???
		
		Date date = new Date();
		this.jdbcTemplate.update("INSERT INTO Cart (user_id, date) VALUES"
		        + "(?,?)"
		        + " ON DUPLICATE KEY UPDATE date = ?"
		      , idUser
		      , date
		      , date);
		
		
		return this.jdbcTemplate.update("INSERT INTO CartProductList (cart_user_id	, product_idProduct, quantity) VALUES"
        + "(?,?,?)"
        + " ON DUPLICATE KEY UPDATE quantity=quantity+1"
      , idUser
      , idProduct
      , 1);

	}

	@Override
	public int removeProductById(long idUser, long idProduct) {
				
		return this.jdbcTemplate.update("DELETE FROM CartProductList WHERE Cart_User_id = ? AND Product_idProduct = ?"
        //+ "(?,?)"
      , idUser
      , idProduct);
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
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
