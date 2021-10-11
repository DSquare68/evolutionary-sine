package com.daniel.evolutionary_sine;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class DimensionInfo {
	static Rectangle2D r2d = Screen.getPrimary().getBounds();

	public static double getWidth() {
		return r2d.getWidth();
	}
	public static double getHeight() {
		return r2d.getHeight();
	}
}
