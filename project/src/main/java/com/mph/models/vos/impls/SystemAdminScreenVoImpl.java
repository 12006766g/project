package com.mph.models.vos.impls;

import com.mph.models.eos.InventoryMasterEo;
import com.mph.models.vos.SystemAdminScreenVo;

public class SystemAdminScreenVoImpl implements SystemAdminScreenVo {
	private InventoryMasterEo inventoryMasterEo;

	public InventoryMasterEo getInventoryMasterEo() {
		return inventoryMasterEo;
	}

	public void setInventoryMasterEo(InventoryMasterEo inventoryMasterEo) {
		this.inventoryMasterEo = inventoryMasterEo;
	}
	
}
