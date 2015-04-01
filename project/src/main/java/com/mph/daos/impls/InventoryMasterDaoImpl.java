package com.mph.daos.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.criteria.IngredientCriteria;
import com.mph.daos.InventoryMasterDao;
import com.mph.factories.InventoryMasterRepositoryFactory;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;
import com.mph.models.eos.InventoryMasterEo;

public class InventoryMasterDaoImpl implements InventoryMasterDao {
	private static final Logger logger = LoggerFactory.getLogger(InventoryMasterDaoImpl.class);
	private InventoryMasterEo inventoryMasterEo;
	
	public InventoryMasterDaoImpl(){
		init();
	}
	
	private void init(){
		try{
			inventoryMasterEo = InventoryMasterRepositoryFactory.getInstance();
		} catch (Exception e){
			logger.error("InventoryMasterDaoImpl.init() - Exception:", e);
		}
	}
	

	public Integer addIngredient(IngredientEo ingredient) {
		Integer id = null;
		try{
			if (inventoryMasterEo != null){
				if (ingredient.getType().equals(IngredientEo.INGREDIENT_TYPE_DECORATOR)){
					id = inventoryMasterEo.addDecorator((DecoratorEo) ingredient);
				} else if (ingredient.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
					id = inventoryMasterEo.addFlavor((FlavorEo) ingredient);
				}
			}
		} catch (Exception e){
			logger.error("InventoryMasterDaoImpl.removeIntegredient() - Exception:", e);
		}
		return id;
	}


	public boolean removeIngredient(IngredientEo ingredient) {
		boolean isDeleted = false;
		try{
			if (inventoryMasterEo != null){
				if (ingredient instanceof DecoratorEo){
					inventoryMasterEo.deleteDecorator((DecoratorEo) ingredient);
				} else if (ingredient instanceof FlavorEo){
					inventoryMasterEo.deleteFlavor((FlavorEo) ingredient);
				}
			}
		} catch (Exception e){
			logger.error("InventoryMasterDaoImpl.removeIntegredient() - Exception:", e);
		}
		return isDeleted;
	}


	public List<DecoratorEo> findDecoratorList(IngredientCriteria criteria) {
		List<DecoratorEo> decoratorEoList = null;
		if (inventoryMasterEo != null){
			decoratorEoList = inventoryMasterEo.findDecorator(criteria);
		}
		return decoratorEoList;
	}
	

	public List<FlavorEo> findFlavorList(IngredientCriteria criteria) {
		List<FlavorEo> flavorEoList = null;
		if (inventoryMasterEo != null){
			flavorEoList = inventoryMasterEo.findFlavorEo(criteria);
		}
		return flavorEoList;
	}

}
