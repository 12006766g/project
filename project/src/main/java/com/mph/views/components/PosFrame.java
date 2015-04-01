package com.mph.views.components;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PosFrame extends JFrame {
	public PosFrame(String title){
		super(title);
		init();
	}
	private void init(){
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
	}
	
	public void addButton(JButton button){
		this.add(button);
		button.setVisible(true);
	}
}
