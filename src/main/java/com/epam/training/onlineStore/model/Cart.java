package com.epam.training.onlineStore.model;

import java.util.Date;
import java.util.List;

public class Cart {

	private User user;
	private Date date;
	
	private List<ProductListItem> productList;
	//private Map<Product, Integer> productList;
	
	public Cart(User user, Date date, List<ProductListItem> productList) {
		this.user = user;
		this.date = date;
		this.productList = productList;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ProductListItem> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductListItem> productList) {
		this.productList = productList;
	}
	
}
