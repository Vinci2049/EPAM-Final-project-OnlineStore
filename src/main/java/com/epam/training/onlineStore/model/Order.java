package com.epam.training.onlineStore.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "products")
public class Order implements Serializable {
	
	private long id;
	private User user;
	private Date date;
	private double cost;
	private boolean isPaid;

	//private List<Product> productList;
	private List<ProductListItem> productList;
	
	private List<Order> orderList;
	
	public Order() {
		
	}
	
	public Order(long id, User user, Date date, double cost, boolean isPaid, List<ProductListItem> productList) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.cost = cost;
		this.isPaid = isPaid;
		this.productList = productList;
	}

	public Order(Cart cart) {
		
		this.date = new Date();
		this.user = cart.getUser();
		this.setIsPaid(false);
		this.productList = cart.getProductList();
		/*for (ProductListItem productListItem : cart.getProductList()) {
			this.productList.add(productListItem);
		}*/

	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<ProductListItem> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductListItem> productList) {
		this.productList = productList;
	}

	public void addItem(Product product, float quantity) {
		ProductListItem productListItem = new ProductListItem(product, quantity);
		this.productList.add(productListItem);
	}
		
	public void addItem(ProductListItem productListItem) {
		this.productList.add(productListItem);
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	public boolean isNew() {
		//return this.id == null;
		return (Long) this.id == null;
	}
	
}
