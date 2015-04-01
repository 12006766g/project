package com.mph.models.eos;

public interface IngredientEo extends Comparable<IngredientEo>{
	public static final String INGREDIENT_TYPE_FLAVOR = "flavor";
	public static final String INGREDIENT_TYPE_DECORATOR = "decorator";
	public Integer getId();
	public void setId(Integer id);
	public void setPrice(Double price);
	public Double getPrice();
	public void setName(String name);
	public String getName();
	public String getType();
	public void setType(String type);
}
