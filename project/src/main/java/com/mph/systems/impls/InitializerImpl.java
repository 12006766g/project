package com.mph.systems.impls;

import com.mph.controls.PosMainController;
import com.mph.controls.PosSystemAdminController;
import com.mph.systems.Initializer;

public class InitializerImpl implements Initializer {

	public static void main(String[] args) {
		PosMainController posMainController = new PosMainController();
		posMainController.show();
		
//		PosSystemAdminController posSystemAdminController = new PosSystemAdminController();
//		posSystemAdminController.show();
	}

}
