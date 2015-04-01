package com.mph.views.listeners;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mph.models.eos.IngredientEo;
import com.mph.models.eos.impls.DecoratorEoImpl;
import com.mph.models.eos.impls.FlavorEoImpl;
import com.mph.utils.CommonUtils;
import com.mph.views.components.PosSysAdmFormPanel;

public class PosIngredientRowListener implements ListSelectionListener {
	private JTable table;
	private IngredientEo ingredientEo;
	private PosSysAdmFormPanel posSysAdmFormPanel;
	public PosIngredientRowListener(IngredientEo ingredientEo, JTable table, PosSysAdmFormPanel posSysAdmFormPanel){
		this.ingredientEo = ingredientEo;
		this.table = table;
		this.posSysAdmFormPanel = posSysAdmFormPanel;
	}
	

	public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            ListSelectionModel model = table.getSelectionModel();
            int lead = model.getLeadSelectionIndex();
            fillSelectedValues2Object(lead);
            fillValues2Components();
        }
	}
	
    private void fillSelectedValues2Object(int rowIndex){

        Object oid = table.getValueAt(rowIndex, 0);
        String id = oid.toString();
        
        Object oname = table.getValueAt(rowIndex, 1);
        String name = oname.toString();

        Object oprice = table.getValueAt(rowIndex, 2);
        String price = oprice.toString();
        
        Object otype = table.getValueAt(rowIndex, 3);
        String type = otype.toString();
        
        if(type != null && !type.isEmpty()){
        	if (type.equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
        		ingredientEo = new FlavorEoImpl();
        	} else if (type.equals(IngredientEo.INGREDIENT_TYPE_DECORATOR)){
        		ingredientEo = new DecoratorEoImpl();
        	}
        }
        
        if (CommonUtils.isInteger(id)){
        	ingredientEo.setId(new Integer(id));
        }
        
        ingredientEo.setName(name);
        
        if (CommonUtils.isNumeric(price)){
        	ingredientEo.setPrice(new Double(price));
        }
        
        ingredientEo.setType(type);
        posSysAdmFormPanel.setIngredientEoCurrentOperation(ingredientEo);
    }

    private void fillValues2Components(){
    	posSysAdmFormPanel.getIdTextField().setText(ingredientEo.getId().toString());
    	posSysAdmFormPanel.getNameTextField().setText(ingredientEo.getName());
    	posSysAdmFormPanel.getPriceTextField().setText(ingredientEo.getPrice().toString());
    	
    	if (ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
    		posSysAdmFormPanel.getTypeComboBox().setSelectedIndex(0);
    	} else {
    		posSysAdmFormPanel.getTypeComboBox().setSelectedIndex(1);    		
    	}
    }
}
