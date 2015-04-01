package com.mph.systems.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class SystemUtils {
	public static Dimension getScreenSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize;
	}
}
