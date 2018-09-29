package com.epam.training.onlineStore.dto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.ProductDAO;
import com.epam.training.onlineStore.dto.mapper.ProductMapper;
import com.epam.training.onlineStore.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }	
	
	@Override
	public List<Product> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM product", new ProductMapper());
	}

	@Override
	public Product findById(long id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?",
                new Object[]{id}, new ProductMapper());
	}
	
	@Override
	public long add(Product product) {

		return this.jdbcTemplate.update("INSERT INTO PRODUCT (name, price, description) VALUES"
                + "(?,?,?)"
                , product.getName()
              	, product.getPrice()
				, product.getDescription());
	}	
	
	@Override
	public long edit(Product product) {

		return this.jdbcTemplate.update("UPDATE PRODUCT SET name = ?, price = ?, description = ? WHERE id = 2"
                , product.getName()
              	, product.getPrice()
				, product.getDescription());
				//, product.getId());
		
		
//		return getJdbcTemplate().update(
//                "UPDATE "
//                        + getTable()
//                        + " SET title = ?, idAuthor = ?, idGenre = ?"
//                        + getWhereId()
//                , entity.getTitle()
//                , entity.getAuthor().getId()
//                , entity.getGenre().getId()
//                , id);
	}	

	
}
