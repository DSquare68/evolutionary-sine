package com.daniel.evolutionary_sine.math;

import java.util.ArrayList;
import javafx.geometry.Point2D;

public class Points{
	public static ArrayList<Point2D> points = new ArrayList<Point2D>();
	
	public Points(ArrayList<Point2D> p) {
		this.points=p;
	}
	public Points() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Point2D> getPoints(){
		return points;
	}
}