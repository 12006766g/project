package com.mph.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mph.views.PosMainView;
import com.mph.views.PosSystemAdminView;

public class PosSystemBack2MainScreenButtonListener implements ActionListener {
	private PosSystemAdminView posSystemAdminView;
	private PosMainView posMainView;
	
	public PosSystemBack2MainScreenButtonListener(PosSystemAdminView posSystemAdminView, PosMainView posMainView){
		this.posMainView = posMainView;
		this.posSystemAdminView = posSystemAdminView;
	}

	public void actionPerformed(ActionEvent e) {
		posMainView.reload();
		posSystemAdminView.unloadComponents();
	}

}
