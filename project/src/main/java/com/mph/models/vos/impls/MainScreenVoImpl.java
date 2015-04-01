package com.mph.models.vos.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.factories.InventoryMasterRepositoryFactory;
import com.mph.models.eos.InventoryMasterEo;
import com.mph.models.vos.IcecreamVo;
import com.mph.models.vos.MainScreenVo;

public class MainScreenVoImpl implements MainScreenVo {
	private static final Logger logger = LoggerFactory.getLogger(MainScreenVoImpl.class);
	private IcecreamVo icecreamVo;
	private InventoryMasterEo inventoryMaster;
	public MainScreenVoImpl(){
		init();
	}
	private void init(){
		try{
			inventoryMaster = InventoryMasterRepositoryFactory.getInstance();
		} catch (Exception e){
			logger.error("MainScreenVoImpl.init() - Exception:", e);
		}
	}
	public InventoryMasterEo getInventoryMasterEo(){
		return inventoryMaster;
	}
	public IcecreamVo getIcecreamVo() {
		return icecreamVo;
	}
	public void setIcecreamVo(IcecreamVo icecreamVo) {
		this.icecreamVo = icecreamVo;
	}
	
}
