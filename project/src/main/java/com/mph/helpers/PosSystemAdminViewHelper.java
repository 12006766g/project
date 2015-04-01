package com.mph.helpers;

import java.util.ArrayList;
import java.util.List;

import com.mph.models.dtos.PosTableDataDto;
import com.mph.models.dtos.impls.PosTableDataDtoImpl;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;

public class PosSystemAdminViewHelper {
	public List<PosTableDataDto> convertDecoratorEoList2PosTableDataDtoList(List<DecoratorEo> decoratorEoList){
		List<PosTableDataDto> posTableDataList = new ArrayList<PosTableDataDto>();
		for (IngredientEo ingredientEo: decoratorEoList){
			PosTableDataDto posTableDataDto = convertFlavorEo2PosTableDataDto(ingredientEo);
			posTableDataList.add(posTableDataDto);
		}
		return posTableDataList;
	}
	public List<PosTableDataDto> convertFlavorEoList2PosTableDataDtoList(List<FlavorEo> flavorEoList){
		List<PosTableDataDto> posTableDataList = new ArrayList<PosTableDataDto>();
		for (IngredientEo ingredientEo: flavorEoList){
			PosTableDataDto posTableDataDto = convertFlavorEo2PosTableDataDto(ingredientEo);
			posTableDataList.add(posTableDataDto);
		}
		return posTableDataList;
	}
	private PosTableDataDto convertFlavorEo2PosTableDataDto(IngredientEo ingredientEo){
		PosTableDataDto posTableDataDto = new PosTableDataDtoImpl();
		String id = "";
		String name = "";
		String price = "";
		String type = "";
		
		if (ingredientEo.getId() != null){
			id = ingredientEo.getId().toString();
		}
		if (ingredientEo.getName() != null){
			name = ingredientEo.getName();
		}
		if (ingredientEo.getPrice() != null){
			price = ingredientEo.getPrice().toString();
		}
		if (ingredientEo.getType() != null){
			type = ingredientEo.getType();
		}
		
		posTableDataDto.setCol1(id);
		posTableDataDto.setCol2(name);
		posTableDataDto.setCol3(price);
		posTableDataDto.setCol4(type);
		
		return posTableDataDto;
	}
	
}
