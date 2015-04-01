package com.mph.controls;

import java.util.List;

import com.mph.factories.InventoryMasterRepositoryFactory;
import com.mph.helpers.InventoryMasterMgrHelper;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.InventoryMasterEo;
import com.mph.views.PosMainView;

public class PosMainController {
	private InventoryMasterEo inventoryMasterEo;
	private InventoryMasterMgrHelper inventoryMasterMgrHelper;
	private PosMainView posMainView;
	public PosMainController(){
		init();
		initDefaultData();
	}
	private void init(){
		inventoryMasterEo = InventoryMasterRepositoryFactory.getInstance();
		inventoryMasterMgrHelper = new InventoryMasterMgrHelper();
	}
	private void initDefaultData(){
		List<FlavorEo> flavorEoList = inventoryMasterMgrHelper.getDefaultFlavorList();
		List<DecoratorEo> decoratorEoList = inventoryMasterMgrHelper.getDefaultDecoratorList();
		
		if (flavorEoList != null && !flavorEoList.isEmpty()){
			for (FlavorEo flavorEo: flavorEoList){
				inventoryMasterEo.addFlavor(flavorEo);
			}
		}
		
		if (decoratorEoList != null && !decoratorEoList.isEmpty()){
			for (DecoratorEo decoratorEo: decoratorEoList){
				inventoryMasterEo.addDecorator(decoratorEo);
			}
		}
	}
	public void uloadPosMainView(){
		posMainView.unloadComponents();
	}
	public void show(){
		posMainView = new PosMainView(inventoryMasterEo);
	}
	
}
