package com.mph.factories;

import com.mph.models.eos.InventoryMasterEo;
import com.mph.models.eos.impls.InventoryMasterEoImpl;

public class InventoryMasterRepositoryFactory {
	private static InventoryMasterEo inventoryMasterEo;
	
	public static InventoryMasterEo getInstance(){
		if (inventoryMasterEo == null){
			inventoryMasterEo = new InventoryMasterEoImpl();
		}
		return inventoryMasterEo;
	}
}
