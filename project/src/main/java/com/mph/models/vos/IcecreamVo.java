package com.mph.models.vos;

import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;


public interface IcecreamVo {
	public Integer getId();
	public void setId(Integer id);
	public void setFlavor(FlavorEo flavor);
	public FlavorEo getFlavor();
	public boolean addDecorator(DecoratorEo decorator);
	public boolean removeDecorator(DecoratorEo decorator);
	public Double getTotal();
}
