package com.epam.training.onlineStore.model;

import java.util.Date;
import java.util.List;

public class Cart {

	private User client;
	private Date date;
	
	private List<ProductListItem> productList;
	//private Map<Product, Integer> productList;
	
	public Cart(User client, Date date, List<ProductListItem> productList) {
		this.client = client;
		this.date = date;
		this.productList = productList;
	}
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
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
