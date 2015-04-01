package com.mph.views.listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mph.factories.BundlesFactory;
import com.mph.models.dtos.BundlesDto;
import com.mph.models.eos.DecoratorEo;
import com.mph.models.eos.FlavorEo;
import com.mph.models.eos.IngredientEo;
import com.mph.models.vos.IcecreamVo;
import com.mph.views.components.PosIngredientButton;

public class PosIngredientButtonListener implements ActionListener {
	private JFrame mainFrame;
	private IngredientEo ingredientEo;
	private IcecreamVo icecreamVo;
	private JLabel jRightTotal;
	private BundlesDto bundlesDto;
	private boolean isSelected = false;
	public PosIngredientButtonListener(JFrame mainFrame, IngredientEo ingredientEo, IcecreamVo icecreamVo, JLabel jRightTotal){
		this.mainFrame = mainFrame;
		this.ingredientEo = ingredientEo;
		this.icecreamVo = icecreamVo;
		this.jRightTotal = jRightTotal;
		init();
	}
	private void init(){
		bundlesDto = BundlesFactory.getBundlesInstance();
	}

	public void actionPerformed(ActionEvent e) {
		toggleButtonSelection();
		if (icecreamVo != null){
			PosIngredientButton button = ((PosIngredientButton) e.getSource());
			String buttonText = button.getText();
			String message;
			if (isSelected){
				if (icecreamVo.getFlavor() != null && ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
					message = "Cannot have two flavors selected at the same time, please click to deselect!!!";
					isSelected = false;
				} else {
					Double total =  ingredientEo.getPrice() +  icecreamVo.getTotal();
					message = buttonText + ":" +  ingredientEo.getPrice() + " + " + icecreamVo.getTotal() + " = " + total;
					addIngredient(ingredientEo);
					button.setIsPressed();
				}
	
			} else {
				Double total =  ingredientEo.getPrice() - icecreamVo.getTotal();
				message = buttonText + ":" +  ingredientEo.getPrice() + " - " + icecreamVo.getTotal() + " = " + total;
				removeIngredient(ingredientEo);
				button.setIsNotPressed();
			}

			if (isSelected){
				JOptionPane.showMessageDialog(mainFrame, message);
			} else {
				JOptionPane.showMessageDialog(mainFrame, message, "Warning", JOptionPane.WARNING_MESSAGE);				
			}
		}
	}

	private void addIngredient(IngredientEo ingredientEo){
		if (ingredientEo != null && ingredientEo.getType() != null ){
			if (ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
				icecreamVo.setFlavor((FlavorEo) ingredientEo);
			}  else if (ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_DECORATOR)){
				icecreamVo.addDecorator((DecoratorEo) ingredientEo);
			}
		}
		jRightTotal.setText(bundlesDto.getTotalLabel() + icecreamVo.getTotal());
	}
	
	private void removeIngredient(IngredientEo ingredientEo){
		if (ingredientEo != null && ingredientEo.getType() != null ){
			if (ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_FLAVOR)){
				icecreamVo.setFlavor(null);
			}  else if (ingredientEo.getType().equals(IngredientEo.INGREDIENT_TYPE_DECORATOR)){
				icecreamVo.removeDecorator((DecoratorEo) ingredientEo);
			}
		}
		jRightTotal.setText(bundlesDto.getTotalLabel() + icecreamVo.getTotal());
	}
	
	private void toggleButtonSelection(){
		if (isSelected){
			isSelected = false;
		} else {
			isSelected = true;
		}
	}
}
