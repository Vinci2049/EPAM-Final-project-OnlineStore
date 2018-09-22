package com.epam.training.onlineStore.model;

//import javax.persistence.Table;

//@Entity
//@Table(name = "products")
public class Product extends NamedEntity {

	private double price;
	private String description;
	
	public Product (String name, double price) {
		this.setName(name);
		this.price = price;
	}

	public Product (int id, String name, double price, String description) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
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
		if (getId() != other.getId())
			return false;
		if (this.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.getName().equals(other.getName()))
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
