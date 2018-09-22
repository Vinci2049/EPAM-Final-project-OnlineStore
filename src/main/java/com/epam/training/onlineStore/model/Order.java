package com.epam.training.onlineStore.model;

import java.util.Date;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "products")
public class Order extends BaseEntity {

	enum Status {registered, paid};
	
	private Status status;
	private Client client;
	private Date date;

	//private List<Product> productList;
	private List<ProductListItem> productList;
	
	private List<Order> orderList;
	
	
	public void printOrder(Order order) {
		System.out.println();
		System.out.println("Заказ клиента № "+order.getId()+" от "+order.getDate());
		System.out.println("Клиент: "+order.getClient().getId()+" - "+order.getClient().getName()+" "+order.getClient().getSurname());
		System.out.println("Товары:");
		//for (Product currentProduct : order.getProductList()) {
		//	System.out.println(currentProduct.getName());
		//}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Order(int id, Date date, Status status, Client client, List<ProductListItem> productList) {
		this.client = client;
		this.date = date;
		this.status = status;
		this.productList = productList;
	}

	public void addItem(Product product, float quantity) {
		ProductListItem productListItem = new ProductListItem(product, quantity);
		this.productList.add(productListItem);
	}
		
	public void addItem(ProductListItem productListItem) {
		this.productList.add(productListItem);
	}

}
