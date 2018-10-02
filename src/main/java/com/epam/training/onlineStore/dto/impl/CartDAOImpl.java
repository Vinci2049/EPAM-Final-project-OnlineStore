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
       , idUser
      , idProduct);
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int clearProductList(long userId) {
		return this.jdbcTemplate.update("DELETE FROM CartProductList WHERE Cart_User_id = ?"
			       , userId);	
	}
	
	
	
	
	
}
