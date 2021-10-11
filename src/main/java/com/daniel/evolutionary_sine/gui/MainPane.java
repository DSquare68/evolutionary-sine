package com.daniel.evolutionary_sine.gui;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainPane extends GridPane{
	private static VBox variables,settings,equations;
	private static  Group chart;
	public MainPane(int colspan,int rowspan) {
		super();
		variables= new MainVBox(null);
		this.add(variables, 1,1,3,2);
	}

	private GraphicsContext graphicsContextInit(int w,int h) {
        Canvas canvas = new Canvas(w, h);
        return canvas.getGraphicsContext2D();
	}
}
