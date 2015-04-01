package com.mph.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mph.models.eos.IngredientEo;
import com.mph.models.eos.impls.DecoratorEoImpl;
import com.mph.models.eos.impls.FlavorEoImpl;
import com.mph.services.InventoryMasterMgr;
import com.mph.services.impls.InventoryMasterMgrImpl;
import com.mph.utils.CommonUtils;
import com.mph.views.components.PosSysAdmFormPanel;

public class PosAddButtonListener implements ActionListener {

	private InventoryMasterMgr inventoryMasterMgr;
	private PosSysAdmFormPanel posSysAdmFormPanel;
	public PosAddButtonListener(PosSysAdmFormPanel posSysAdmFormPanel){
		this.posSysAdmFormPanel = posSysAdmFormPanel;
		init();
	}
	private void init(){
		inventoryMasterMgr = new InventoryMasterMgrImpl();
	}

	public void actionPerformed(ActionEvent e) {
		IngredientEo ingredientEo;
		String type = (String) posSysAdmFormPanel.getTypeComboBox().getSelectedItem();		
		if (type.equals(IngredientEo.INGREDIENT_TYPE_DECORATOR)){
			ingredientEo = new DecoratorEoImpl();
		} else {
			ingredientEo = new FlavorEoImpl();
		}
		
		ingredientEo.setId(null);
		
		String name = posSysAdmFormPanel.getNameTextField().getText();
		String price = posSysAdmFormPanel.getPriceTextField().getText();

		Double priceD = null;		
		boolean isDataValid = true;
		if (CommonUtils.isNumeric(price)){
			priceD = new Double(price);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "price must be numeric input!!!");
			isDataValid = false;
		}
 
		if(isDataValid){
			ingredientEo.setName(name);
			ingredientEo.setPrice(priceD);
			ingredientEo.setType(type);
			inventoryMasterMgr.addIngredient(ingredientEo);
			JOptionPane.showMessageDialog(new JFrame(), "record saved!");
			posSysAdmFormPanel.refresh();		
		}
		

	}

}
