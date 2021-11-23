package com.daniel.evolutionary_sine;

import java.util.ArrayList;

import com.daniel.evolutionary_sine.gui.MainPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class EvolutionarySine extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var width = DimensionInfo.getWidth();
        var height = DimensionInfo.getHeight();

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new MainPane(7,5), width*0.8, height*0.8);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public class Points{
    	private ArrayList<Point> points = new ArrayList<Point>();
    	
    	public Points(ArrayList<Point> p) {
    		this.points=p;
    	}
    	public Points() {
			// TODO Auto-generated constructor stub
		}
		public ArrayList<Point> getPoints(){
    		return points;
    	}
    }
    public class Point{
    	public Point(double d, double e) {
			this.x=d;
			this.y=e;
		}

		public double x,y;
    }
}