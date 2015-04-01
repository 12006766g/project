package com.mph.views.components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class PosLabel extends JLabel {
	public PosLabel() {
		init();
	}

	private void init() {
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

		this.setBorder(border);
	}
}
