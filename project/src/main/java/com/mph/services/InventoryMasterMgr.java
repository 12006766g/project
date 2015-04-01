package com.mph.services;

import java.util.List;

import com.mph.criteria.IngredientCriteria;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;

public interface InventoryMasterMgr {
	public Integer addIngredient(IngredientEo ingredient);
	public void removeIngredient(IngredientEo ingredient);
	public List<DecoratorEo> findDecoratorList(IngredientCriteria criteria);
	public List<FlavorEo> findFlavorList(IngredientCriteria criteria);
}
