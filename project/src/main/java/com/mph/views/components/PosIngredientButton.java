package com.mph.views.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mph.models.eos.IngredientEo;

public class PosIngredientButton extends JButton{
	public PosIngredientButton(){
		init();
	}
	private void init(){
		this.setBackground(Color.WHITE);
	}
	public void setIsPressed(){
		this.setBackground(Color.CYAN);
	}
	public void setIsNotPressed(){
		this.setBackground(Color.WHITE);
	}

}
