package com.mph.models.eos.impls;

import com.mph.models.eos.IngredientEo;

public abstract class Ingredient implements Comparable<IngredientEo>{
	protected Integer id;
	protected Double price;
	protected String name;
	protected String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int compareTo(IngredientEo o) {
		return getId().compareTo(o.getId());
	}
	
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", price=" + price + ", name=" + name
				+ ", type=" + type + "]";
	}
	
	
}
