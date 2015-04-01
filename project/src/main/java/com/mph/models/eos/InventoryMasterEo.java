package com.mph.models.eos;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import com.mph.criteria.IngredientCriteria;

public interface InventoryMasterEo {
	public ConcurrentMap<Integer, FlavorEo> getFlavorMap();
	public ConcurrentMap<Integer, DecoratorEo> getDecoratorMap();
	public Integer addFlavor(FlavorEo flavor);
	public Integer addDecorator(DecoratorEo decorator);
	public boolean deleteFlavor(FlavorEo flavor);
	public boolean deleteDecorator(DecoratorEo decorator);
	public List<FlavorEo> findFlavorEo(IngredientCriteria criteria);
	public List<DecoratorEo> findDecorator(IngredientCriteria criteria);
}
