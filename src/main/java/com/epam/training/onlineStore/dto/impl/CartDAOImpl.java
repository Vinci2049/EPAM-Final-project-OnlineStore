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
import com.epam.training.onlineStore.dto.mapper.ProductListItemMapper;
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
		//return this.jdbcTemplate.queryForObject("Select * from cart join cartproductlist on client_idClient = cart_client_idClient where client_idClient = ? limit 1",
		//return (Cart) this.jdbcTemplate.query("Select * from cart join cartproductlist on client_idClient = cart_client_idClient where client_idClient = ?",
        //        new Object[]{idClient}, new CartMapper());
		Cart cart = this.jdbcTemplate.queryForObject("Select * from cart where client_idClient = ?",
                new Object[]{idClient}, new CartMapper());
		
		List<ProductListItem> productList = this.jdbcTemplate.query("Select * from cartproductlist left join product on product_idProduct = id where cart_client_idClient = ?",
                new Object[]{idClient}, new ProductListItemMapper());
		
		cart.setProductList(productList);
		
		return cart;
		
		//return this.jdbcTemplate.query("SELECT * FROM cart", new CartMapper());
	}
	
	
	@Override
	public int addProductById(long idProduct) {
		
		
		// ВРЕМЕННО
		int idClient = 1;
				
		// Надо сначала выбрать, вдруг такой товар уже есть, тогда его инкрементируем
		// Корзины это тоже касается

		
		return this.jdbcTemplate.update("INSERT INTO CartProductList (cart_client_idclient, product_idProduct, quantity) VALUES"
        + "(?,?,?)"
        + " ON DUPLICATE KEY UPDATE quantity=quantity+1"
      , idClient
      , idProduct
      , 1);

		//mysql_query("INSERT INTO Progress ( Id_Stud, Id_Subj, Mark) VALUES ('".$User_Data['id']."','".$id."', '".$Mark."') ON DUPLICATE KEY UPDATE Mark='".$Mark."';");
		
		
		
//		List<ProductListItem> productList = this.jdbcTemplate.query("Select * from cartproductlist left join product on product_idProduct = id where cart_client_idClient = ?",
//                new Object[]{idClient}, new ProductListItemMapper());
//
//		boolean isContains = false;
//		for(ProductListItem currentItem : productList) {
//			if (currentItem.getProduct().getId() == idProduct) {
//				currentItem.setQuantity(currentItem.getQuantity()+1);
//				isContains = true;
//				break;
//			}
//		}
//		if (!isContains) {
//			//productList.add(new ProductListItem(Product.getById(idProduct), 1.0);
//			return this.jdbcTemplate.update("INSERT INTO CartProductList (cart_client_idclient, product_idProduct, quantity) VALUES"
//		            + "(?,?,?)"
//		          , idClient
//		          , idProduct
//		          , 1);			
//		}		
		
//		return this.jdbcTemplate.update("INSERT INTO CartProductList (cart_client_idclient, product_idProduct, quantity) VALUES"
//	            + "(?,?,?)"
//	          , idClient
//	          , idProduct
//	          , 1);

	}

	@Override
	public int removeProductById(long idProduct) {
		// ВРЕМЕННО
		int idClient = 1;
				
		return this.jdbcTemplate.update("DELETE FROM CartProductList WHERE cart_client_idclient = ? AND product_idProduct = ?"
        //+ "(?,?)"
      , idClient
      , idProduct);
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
