package com.daniel.evolutionary_sine.gui;

import com.daniel.evolutionary_sine.math.Equation;

import javafx.scene.Group;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GraphPane extends LineChart<Number, Number>{
	final static Axis<Number> xAxis= new NumberAxis(-25,25,1);
	final static Axis<Number> yAxis= new NumberAxis(-15,15,1);
	
	public GraphPane() {
		super(xAxis, yAxis);
		Equation e = new Equation();
		XYChart.Series series = new XYChart.Series();
		for(double i=-25;i<26; i+=0.1) {
			series.getData().add(new XYChart.Data(i, e.getY(i)));
			System.out.println(i);
		}
        this.setCreateSymbols(false);
        this.getData().add(series);
	}
	public GraphPane(Axis<Number> xAxis, Axis<Number> yAxis) {
		super(xAxis, yAxis);
		
	}

}
