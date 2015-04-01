package com.mph.models.eos.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mph.criteria.IngredientCriteria;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;
import com.mph.models.eos.InventoryMasterEo;

public class InventoryMasterEoImpl implements InventoryMasterEo {
	private static final Logger logger = LoggerFactory.getLogger(InventoryMasterEoImpl.class);
	private ConcurrentMap<Integer, FlavorEo> flavorMap;
	private ConcurrentMap<Integer, DecoratorEo> decoratorMap;
	private Integer flavorMapMaxId;
	private Integer decoratorMapMaxId;
	
	private Integer getNextDecoratorId(){
		decoratorMapMaxId++;
		Integer nextId = decoratorMapMaxId;
		return nextId;
	}
	
	private Integer getNextFlavorId(){
		flavorMapMaxId++;
		Integer nextId = flavorMapMaxId;
		return nextId;
	}
	
	public InventoryMasterEoImpl(){
		init();
	}
	private void init(){
		try{
			flavorMap = new ConcurrentHashMap<Integer, FlavorEo>();
			decoratorMap = new ConcurrentHashMap<Integer, DecoratorEo>();
			flavorMapMaxId = 0;
			decoratorMapMaxId = 0;
		} catch (Exception e){
			logger.error("InventoryMasterImpl.init() - Exception:", e);
		}
	}
	

	public ConcurrentMap<Integer, FlavorEo> getFlavorMap() {
		return flavorMap;
	}


	public ConcurrentMap<Integer, DecoratorEo> getDecoratorMap() {
		return decoratorMap;
	}


	public Integer addFlavor(FlavorEo flavor) {
		Integer id = null;
		try{
			Integer nextId = getNextFlavorId(); 
			flavor.setId(nextId);
			flavorMap.put(flavor.getId(), flavor);
			id = nextId;
		} catch (Exception e){
			logger.error("InventoryMasterImpl.addFlavor() - Exception:", e);			
		}
		return id;
	}


	public Integer addDecorator(DecoratorEo decorator) {
		Integer id = null;
		try{
			Integer nextId = getNextDecoratorId();
			decorator.setId(nextId);
			decoratorMap.put(decorator.getId(), decorator);
			id = nextId;
		} catch (Exception e){
			logger.error("InventoryMasterImpl.addDecorator() - Exception:", e);				
		}
		return id;
	}


	public boolean deleteFlavor(FlavorEo flavor) {
		boolean isDeleted = false;
		try{
			flavorMap.remove(flavor.getId());
			isDeleted = true;
		} catch (Exception e){
			logger.error("InventoryMasterImpl.deleteFlavor() - Exception:", e);	
		}
		return isDeleted;
	}


	public boolean deleteDecorator(DecoratorEo decorator) {
		boolean isDeleted = false;
		try{
			decoratorMap.remove(decorator.getId());
		} catch (Exception e){
			logger.error("InventoryMasterImpl.deleteDecorator() - Exception:", e);	
		}
		return isDeleted;
	}


	public List<FlavorEo> findFlavorEo(IngredientCriteria criteria) {
		List<FlavorEo> flavorEoList = null;
		try{
			if (flavorMap.size() > 0){
				flavorEoList = new ArrayList<FlavorEo>();
				Iterator<Entry<Integer, FlavorEo>> flavorIterator = flavorMap.entrySet().iterator();
				while (flavorIterator.hasNext()){
					Map.Entry<Integer, FlavorEo> pair = (Map.Entry<Integer, FlavorEo>) flavorIterator.next();
					FlavorEo flavorEo = pair.getValue();
					if (criteria.getId() != null && criteria.getType() != null && criteria.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
						if (flavorEo.getId() != null && flavorEo.getId().intValue() == criteria.getId().intValue()){
							flavorEoList.add(flavorEo);
							break;
						}
					} else { // find all
						flavorEoList.add(flavorEo);
					}
					
				}
			}
		} catch (Exception e){
			logger.error("InventoryMasterEoImpl.findFlavorEo() - Exception:", e);
		}
		return flavorEoList;
	}


	public List<DecoratorEo> findDecorator(IngredientCriteria criteria) {
		List<DecoratorEo> decoratorEoList = null;
		try{
			if (decoratorMap.size() > 0){
				decoratorEoList = new ArrayList<DecoratorEo>();
				Iterator<Entry<Integer, DecoratorEo>> decoratorIterator = decoratorMap.entrySet().iterator();
				while (decoratorIterator.hasNext()){
					Map.Entry<Integer, DecoratorEo> pair = (Map.Entry<Integer, DecoratorEo>) decoratorIterator.next();
					DecoratorEo decoratorEo = pair.getValue();
					if (criteria.getId() != null && criteria.getType() != null && criteria.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
						if (decoratorEo.getId() != null && decoratorEo.getId().intValue() == criteria.getId().intValue()){
							decoratorEoList.add(decoratorEo);
							break;
						}
					} else { // find all
						decoratorEoList.add(decoratorEo);
					}
					
				}
			}
		} catch (Exception e){
			logger.error("InventoryMasterEoImpl.findDecorator() - Exception:", e);
		}
		return decoratorEoList;
	}

}
