package com.epam.training.onlineStore.model;

public class ProductListItem {
	
	private long listItemId;
	private Product product;
	private float quantity;
	
	public ProductListItem(Product product, float quantity) {
		this.setProduct(product);
		this.setQuantity(quantity);
	}
		
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public long getListItemId() {
		return listItemId;
	}
	public void setListItemId(long listItemId) {
		this.listItemId = listItemId;
	}
	 
}
