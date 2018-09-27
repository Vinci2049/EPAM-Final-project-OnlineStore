package com.epam.training.onlineStore.model;

//@MappedSuperclass
public class NamedEntity extends BaseEntity {
	
	//@Column(name = "name")
	protected String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
}
