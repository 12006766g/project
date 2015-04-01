package com.mph.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mph.models.eos.IngredientEo;
import com.mph.services.InventoryMasterMgr;
import com.mph.services.impls.InventoryMasterMgrImpl;
import com.mph.views.components.PosSysAdmFormPanel;

public class PosDeleteButtonListener implements ActionListener {

	private InventoryMasterMgr inventoryMasterMgr;
	private PosSysAdmFormPanel posSysAdmFormPanel;
	public PosDeleteButtonListener(PosSysAdmFormPanel posSysAdmFormPanel){
		this.posSysAdmFormPanel = posSysAdmFormPanel;
		init();
	}
	
	private void init(){
		inventoryMasterMgr = new InventoryMasterMgrImpl();
	}
	

	public void actionPerformed(ActionEvent e) {
		IngredientEo ingredientEo = posSysAdmFormPanel.getIngredientEoCurrentOperation();
		inventoryMasterMgr.removeIngredient(ingredientEo);
		JOptionPane.showMessageDialog(new JFrame(), "record deleted!");
		posSysAdmFormPanel.refresh();
	}

}
