package com.mph.models.eos.impls;

import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.IngredientEo;

public class DecoratorEoImpl extends Ingredient implements DecoratorEo {	
	public DecoratorEoImpl(){
		super();
		init();
	}
	private void init(){
		type = IngredientEo.INGREDIENT_TYPE_DECORATOR;
	}


}
