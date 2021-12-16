package com.daniel.evolutionary_sine.gui;

import com.daniel.evolutionary_sine.DimensionInfo;
import com.daniel.evolutionary_sine.math.Points;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VariablesPane extends VBox{
	private static GridPane center;
	private static  HBox bottom;
	private double height,width; 
	public VariablesPane(boolean b) {}
	public VariablesPane() {
		this.getStylesheets().add(getClass().getResource("/pane/variables.css").toExternalForm());
		center = new  GridPane();
		center.getStyleClass().add("center");
		center.setHgap(DimensionInfo.H_GAP/4.0);
		center.setVgap(DimensionInfo.V_GAP/8.0);
		//for(int i=0;i<10;i++)
			//center.add(new PointPane(new Object[] {1+i, 1+i/7.0,1+i/11.0+1}),i%2*2,i%2==0 ? i/2 : (i-1)/2 ,2,1 );
		setBottom();
		this.getChildren().addAll(center,bottom);
	}
	public  static void setValues() {
		VariablesPane vp = new VariablesPane(true);
		for(int i =0; i<Points.points.size();i++)
			center.add(vp.new PointPane(new Object[] {1,Points.points.get(i).getX(), Points.points.get(i).getY()}),i%2*2,i%2==0 ? i/2 : (i-1)/2 ,2,1);
	}
	private void setBottom() {
		Label xl= new Label("Set X:"), yl= new Label("Set Y:");
		TextField xf= new TextField(),yf= new TextField();
		xf.setPrefWidth(DimensionInfo.WIDTH/17.0);
		yf.setPrefWidth(DimensionInfo.WIDTH/17.0);
		Button add = new Button("Add");
		bottom = new HBox();
		bottom.getStyleClass().add("bottom");
		bottom.getChildren().addAll(xl,xf,yl,yf,add);
		add.setOnAction(e->{
			Points.points.add(new Point2D(Double.valueOf(xf.getText().toString()),Double.valueOf(yf.getText().toString())));
			GraphPane.setData(Points.points.get(Points.points.size()-1));
		});
	}
	
	private GraphicsContext graphicsContextInit(int w,int h) {
        Canvas canvas = new Canvas(w, h);
        return canvas.getGraphicsContext2D();
	}
	
	class PointPane extends HBox {
		private final String POINTS = "%d. X: %.2f Y: %.2f", POINT="point"; 
		private Label points;
		private Button delete;
		
		public PointPane(Object[] s) {
			this.getStyleClass().add(POINT);
			if(s==null)
				s= new Object[] {1,0.756453,2.946353};
			points= new Label(String.format(POINTS, s));
			delete = new Button("\u2716");
			this.getChildren().addAll(points,delete);
			this.setMinWidth(DimensionInfo.H_GAP/4.0/2.0);
			this.setMinHeight(DimensionInfo.V_GAP/6.0);
		}
	}
}
