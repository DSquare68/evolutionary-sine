package com.daniel.evolutionary_sine.gui;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VariablesPane extends VBox{
	private static VBox variables,settings,equations;
	private static  Group chart;

	private GraphicsContext graphicsContextInit(int w,int h) {
        Canvas canvas = new Canvas(w, h);
        return canvas.getGraphicsContext2D();
	}
}
