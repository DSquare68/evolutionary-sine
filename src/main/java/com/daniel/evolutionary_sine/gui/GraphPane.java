package com.daniel.evolutionary_sine.gui;

import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.Points;

import javafx.geometry.Point2D;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.awt.geom.Point2D.Double;

public class GraphPane extends LineChart<Number, Number>{
	final static Axis<Number> xAxis= new NumberAxis(-25,25,1);
	final static Axis<Number> yAxis= new NumberAxis(-15,15,1);
	final static XYChart.Series seriesPoints = new XYChart.Series();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GraphPane() {
		super(xAxis, yAxis);
		Equation e = new Equation();
		
		this.getData().add(seriesPoints);
		this.setOnMouseClicked(m->{
			if(Points.points.size()>9)
				return;
			Point2D p = new Point2D((double)xAxis.getValueForDisplay(m.getX())-1.65,(double)yAxis.getValueForDisplay(m.getY())+1.0);
			Points.points.add(p);
			VariablesPane.setValues();
			GraphPane.setData(p);
		});
		XYChart.Series series = new XYChart.Series();
		for(double i=-25;i<26; i+=0.1)
			series.getData().add(new XYChart.Data(i, e.getY(i)));
        this.setCreateSymbols(true); //dots
        this.getData().add(series);
	}
	public static void setData(Point2D p){
		seriesPoints.getData().add(new XYChart.Data(p.getX(),p.getY()));
	
	}
	public GraphPane(Axis<Number> xAxis, Axis<Number> yAxis) {
		super(xAxis, yAxis);
		
	}

}
