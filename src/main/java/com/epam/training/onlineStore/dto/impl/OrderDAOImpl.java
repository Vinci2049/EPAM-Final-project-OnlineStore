package com.epam.training.onlineStore.dto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.OrderDAO;
import com.epam.training.onlineStore.dto.mapper.OrderMapper;
import com.epam.training.onlineStore.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(long id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = ?",
                new Object[]{id}, new OrderMapper());
	}

	@Override
	public long add(Order t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long edit(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		return 0;
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
