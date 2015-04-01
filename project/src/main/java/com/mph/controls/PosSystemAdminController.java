package com.mph.controls;

import java.util.List;

import com.mph.factories.InventoryMasterRepositoryFactory;
import com.mph.helpers.InventoryMasterMgrHelper;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.InventoryMasterEo;
import com.mph.views.PosMainView;
import com.mph.views.PosSystemAdminView;

public class PosSystemAdminController {
	private InventoryMasterEo inventoryMasterEo;
	private InventoryMasterMgrHelper inventoryMasterMgrHelper;
	private PosMainView posMainView;
	public PosSystemAdminController(){
		init();
		initDefaultData();
	}
	public PosSystemAdminController(PosMainView posMainView){
		this.posMainView = posMainView;
		init();
		// need to be inited once only
//		initDefaultData();
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
	private void init(){
		inventoryMasterEo = InventoryMasterRepositoryFactory.getInstance();
		inventoryMasterMgrHelper = new InventoryMasterMgrHelper();
	}

	public void show(){
		PosSystemAdminView posSystemAdminView = new PosSystemAdminView(posMainView);
	}
}
