package com.mph.helpers;

import java.util.ArrayList;
import java.util.List;

import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.impls.DecoratorEoImpl;
import com.mph.models.eos.impls.FlavorEoImpl;

public class InventoryMasterMgrHelper {
	private List<FlavorEo> flavorEoList;
	private List<DecoratorEo> decoratorEoList;
	public InventoryMasterMgrHelper(){
		init();
		generateDefaultInventory();
	}
	private void generateDefaultInventory(){
		FlavorEo flavorEo1 = new FlavorEoImpl();
		flavorEo1.setName("Chocolate");
		flavorEo1.setPrice(20d);
		
		flavorEoList.add(flavorEo1);
		
		FlavorEo flavorEo2 = new FlavorEoImpl();
		flavorEo2.setName("Vanilla");
		flavorEo2.setPrice(20d);
		
		flavorEoList.add(flavorEo2);
		
		DecoratorEo decoratorEo1 = new DecoratorEoImpl();
		decoratorEo1.setName("M&M");
		decoratorEo1.setPrice(5d);
		
		decoratorEoList.add(decoratorEo1);
		
		DecoratorEo decoratorEo2 = new DecoratorEoImpl();
		decoratorEo2.setName("Strawberry");
		decoratorEo2.setPrice(4d);
		
		decoratorEoList.add(decoratorEo2);
	}
	private void init(){
		flavorEoList = new ArrayList<FlavorEo>();
		decoratorEoList = new ArrayList<DecoratorEo>();
	}
	public List<FlavorEo> getDefaultFlavorList(){
		return flavorEoList;
	}
	public List<DecoratorEo> getDefaultDecoratorList(){
		return decoratorEoList;
	}
}
