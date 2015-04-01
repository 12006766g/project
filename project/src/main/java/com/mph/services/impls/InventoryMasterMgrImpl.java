package com.mph.services.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.criteria.IngredientCriteria;
import com.mph.daos.InventoryMasterDao;
import com.mph.daos.impls.InventoryMasterDaoImpl;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;
import com.mph.services.InventoryMasterMgr;

public class InventoryMasterMgrImpl implements InventoryMasterMgr {
	private static final Logger logger = LoggerFactory.getLogger(InventoryMasterMgrImpl.class);
	private InventoryMasterDao inventoryMasterDao;

	public InventoryMasterMgrImpl(){
		init();
	}
	
	private void init(){
		try{
			inventoryMasterDao = new InventoryMasterDaoImpl();
		} catch (Exception e){
			logger.error("InventoryMasterMgrImpl.init() - Exception:", e);
		}
	}
	
	public Integer addIngredient(IngredientEo ingredient) {
		Integer id = null;
		try{
			id = inventoryMasterDao.addIngredient(ingredient);
		} catch (Exception e){
			logger.error("InventoryMasterMgrImpl.addIngredient() - Exception:", e);
		}
		return id;
	}


	public void removeIngredient(IngredientEo ingredient) {
		try{
			inventoryMasterDao.removeIngredient(ingredient);
		} catch (Exception e){
			logger.error("InventoryMasterMgrImpl.removeIngredient() - Exception:", e);
		}
	}
	
	public List<DecoratorEo> findDecoratorList(IngredientCriteria criteria){
		List<DecoratorEo> decoratorEoList = null;
		try{
			decoratorEoList = inventoryMasterDao.findDecoratorList(criteria);
		} catch (Exception e){
			logger.error("InventoryMasterMgrImpl.findIngredient() - Exception:", e);
		}
		return decoratorEoList;
	}
	public List<FlavorEo> findFlavorList(IngredientCriteria criteria){
		List<FlavorEo> flavorEoList = null;
		try{
			flavorEoList = inventoryMasterDao.findFlavorList(criteria);
		} catch (Exception e){
			logger.error("InventoryMasterMgrImpl.findIngredient() - Exception:", e);
		}
		return flavorEoList;
	}

}
