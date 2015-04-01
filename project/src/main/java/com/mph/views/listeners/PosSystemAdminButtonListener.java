package com.mph.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mph.controls.PosSystemAdminController;
import com.mph.views.PosMainView;

public class PosSystemAdminButtonListener implements ActionListener {

	private PosMainView posMainView;
	private PosSystemAdminController posSystemAdminController;
	public PosSystemAdminButtonListener(PosMainView posMainView){
		this.posMainView = posMainView;
	}

	public void actionPerformed(ActionEvent e) {
		posSystemAdminController = new PosSystemAdminController(posMainView);
		posSystemAdminController.show();
	}

}
