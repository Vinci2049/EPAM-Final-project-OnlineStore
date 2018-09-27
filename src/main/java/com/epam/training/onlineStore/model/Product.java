package com.epam.training.onlineStore.model;

//import javax.persistence.Table;

//@Entity
//@Table(name = "products")
public class Product extends NamedEntity {

	private double price;
	private String description;

	public Product () {
	}	
	
	public Product (String name, double price, String description) {
		//this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
	}

	public Product (long id, String name, double price, String description) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
	}

	// ДОБАВИТЬ ID в hashCode и Equals ??
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
