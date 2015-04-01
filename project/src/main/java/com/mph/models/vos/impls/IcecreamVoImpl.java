package com.mph.models.vos.impls;

import java.util.HashMap;
import java.util.Map;

import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.vos.IcecreamVo;

public class IcecreamVoImpl implements IcecreamVo {
	private Integer id;
	private FlavorEo flavor;
	private Map<Integer, DecoratorEo> decoratorMap;
	private Double total;
	
	public IcecreamVoImpl(){
		init();
	}
	private void init(){
		decoratorMap = new HashMap<Integer, DecoratorEo>();
		total = 0d;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setFlavor(FlavorEo flavor) {
		if (flavor != null){
			if (this.flavor != null){
				substractTotal(this.flavor.getPrice());
			}
			this.flavor = flavor;
			addTotal(this.flavor.getPrice());
		} else { // set null no total added
			if (this.flavor != null){
				substractTotal(this.flavor.getPrice());
			}
			this.flavor = flavor;
		}
	}


	public FlavorEo getFlavor() {
		return this.flavor;
	}


	public boolean addDecorator(DecoratorEo decorator) {
		boolean isAdded = false;
		if (decorator != null){
			addTotal(decorator.getPrice());
			decoratorMap.put(decorator.getId(), decorator);
			isAdded = true;
		}
		return isAdded;
	}

	private void addTotal(Double price){
		total += price;
	}
	
	private void substractTotal(Double price){
		total -= price;
	}
	

	public boolean removeDecorator(DecoratorEo decorator) {
		boolean isAdded = false;
		if (decorator != null){
			substractTotal(decorator.getPrice());
			decoratorMap.remove(decorator.getId());
		}
		return isAdded;
	}


	public Double getTotal() {
		return total;
	}

}
