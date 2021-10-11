package com.daniel.evolutionary_sine.gui;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainVBox extends VBox{
	public MainVBox(Color c) {
		super();
		this.getStylesheets().add(getClass().getResource("/evolutionary-sine/src/main/java/css/MainVBox.css").toString());
		this.setLayoutX(300);
		this.setLayoutY(300);
	}
}
