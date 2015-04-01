package com.mph.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mph.views.PosMainView;

public class PosNewIcecreamButtonListener implements ActionListener {
	private PosMainView posMainView;
	
	public PosNewIcecreamButtonListener(PosMainView posMainView){
		this.posMainView = posMainView;
	}

	public void actionPerformed(ActionEvent e) {
		posMainView.reload();
	}

}
