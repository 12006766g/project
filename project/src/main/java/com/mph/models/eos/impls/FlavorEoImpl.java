package com.mph.models.eos.impls;

import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;

public class FlavorEoImpl extends Ingredient implements FlavorEo{
	public FlavorEoImpl(){
		init();
	}
	private void init(){
		type = IngredientEo.INGREDIENT_TYPE_FLAVOR;
	}

}
