package com.daniel.evolutionary_sine.gui;

import com.daniel.evolutionary_sine.engine.Engine;
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
	XYChart.Series series = new XYChart.Series();
	Equation e; 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GraphPane() {
		super(xAxis, yAxis);
		this.setAnimated(false);
		this.getData().add(seriesPoints);
		this.setOnMouseClicked(m->{
			if(Points.points.size()>9)
				return;
			Point2D p = new Point2D((double)xAxis.getValueForDisplay(m.getX())-1.65,(double)yAxis.getValueForDisplay(m.getY())+1.0);
			Points.points.add(p);
			VariablesPane.setValues();
			GraphPane.setData(p);
		});
		  this.setCreateSymbols(true); //dots
		draw();
	}
	public void draw() {	
		e = setEquestion();
		if(e==null)
			return;
		//this.getData().clear();
		this.setAnimated(false);
		this.getData().remove(series);
		series.getData().clear();
		for(double i=-25;i<26; i+=0.1)
			series.getData().add(new XYChart.Data(i, e.getY(i)));
        this.getData().addAll(series);
		
	}
	private Equation setEquestion() {
		if(Engine.eqF.size()==0)
			return null;
		return Engine.eqF.get(0).getEquation();
		
	}
	public static void setData(Point2D p){
		seriesPoints.getData().add(new XYChart.Data(p.getX(),p.getY()));
	
	}
	public GraphPane(Axis<Number> xAxis, Axis<Number> yAxis) {
		super(xAxis, yAxis);
		
	}

}
