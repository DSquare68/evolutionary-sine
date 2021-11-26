package com.daniel.evolutionary_sine.gui;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VariableVBox extends VBox{
	public VariableVBox(Color c) {
		super();
		this.getStylesheets().add(getClass().getResource("/evolutionary-sine/src/main/java/css/MainVBox.css").toString());
		this.setLayoutX(300);
		this.setLayoutY(300);
	}
}
