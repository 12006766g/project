package com.mph.views.components;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import com.mph.factories.BundlesFactory;
import com.mph.models.dtos.BundlesDto;
import com.mph.models.eos.IngredientEo;
import com.mph.views.PosSystemAdminView;
import com.mph.views.listeners.PosAddButtonListener;
import com.mph.views.listeners.PosDeleteButtonListener;
import com.mph.views.listeners.PosNewButtonListener;

public class PosSysAdmFormPanel extends JPanel {
	private BundlesDto bundlesDto;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JButton addButton;
	private JButton deleteButton;
	private JButton newButton;
	private JComboBox<String> typeComboBox;
	private IngredientEo ingredientEoCurrentOperation;	
	private PosSystemAdminView posSystemAdminView;
	public PosSysAdmFormPanel(PosSystemAdminView posSystemAdminView){
		this.posSystemAdminView = posSystemAdminView;
		this.ingredientEoCurrentOperation = posSystemAdminView.getIngredientEoCurrentOperation();
		init();
	}
	
	
	public IngredientEo getIngredientEoCurrentOperation() {
		return ingredientEoCurrentOperation;
	}


	public JTextField getIdTextField() {
		return idTextField;
	}


	public void setIngredientEoCurrentOperation(IngredientEo ingredientEoCurrentOperation) {
		posSystemAdminView.setIngredientEoCurrentOperation(ingredientEoCurrentOperation);
		this.ingredientEoCurrentOperation = posSystemAdminView.getIngredientEoCurrentOperation();
	}


	public JTextField getNameTextField() {
		return nameTextField;
	}


	public JTextField getPriceTextField() {
		return priceTextField;
	}


	public JComboBox<String> getTypeComboBox() {
		return typeComboBox;
	}


	private void init(){

		bundlesDto = BundlesFactory.getBundlesInstance();
		
		this.setLayout(new MigLayout("fill"));  
		
		this.add(new JLabel(bundlesDto.getTableColumnNameId()));
		idTextField = new JTextField(25);
		idTextField.setEnabled(false);
		this.add(idTextField, "growx, wrap");
		  
		this.add(new JLabel(bundlesDto.getTableColumnNameName()));
		nameTextField = new JTextField(255);
		this.add(nameTextField, "growx, wrap");
		  
		this.add(new JLabel(bundlesDto.getTableColumnNamePrice()));
		priceTextField = new JTextField(25);
		this.add(priceTextField, "growx, wrap");
		  
		this.add(new JLabel(bundlesDto.getTableColumnNameType()));		
		String[] typeArray = { IngredientEo.INGREDIENT_TYPE_FLAVOR, IngredientEo.INGREDIENT_TYPE_DECORATOR };
		typeComboBox = new JComboBox<String>(typeArray);
		this.add(typeComboBox, "growx, wrap");
		addButton = new JButton("Add");
		PosAddButtonListener posAddButtonListener = new PosAddButtonListener(this);
		addButton.addActionListener(posAddButtonListener);
		
		deleteButton = new JButton("Delete");
		PosDeleteButtonListener posDeleteButtonListener = new PosDeleteButtonListener(this);
		deleteButton.addActionListener(posDeleteButtonListener);

		newButton = new JButton("New");
		PosNewButtonListener posNewButtonListener = new PosNewButtonListener(this);
		newButton.addActionListener(posNewButtonListener);

		this.add(newButton);
		this.add(addButton);
		this.add(deleteButton);

	}
	public void refresh(){
		idTextField.setText("");
		nameTextField.setText("");
		priceTextField.setText("");
		this.repaint();
		posSystemAdminView.refresh();
	}
}
