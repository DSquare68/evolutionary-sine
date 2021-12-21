package com.daniel.evolutionary_sine.gui;

import java.util.ArrayList;

import com.daniel.evolutionary_sine.math.Equation;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EquationsPane extends VBox{
	public static ArrayList<LabelText> labelsText; 
	public static ArrayList<EquationLabel> labels; 

	public EquationsPane() {
		this.getStylesheets().add(getClass().getResource("/pane/equations.css").toExternalForm());
		labelsText = new ArrayList<>();
		labels = new ArrayList<>();
		for(int i=0;i<100;i++) {
			labelsText.add(new LabelText(new Equation(), i+1, 1));
			if(i>49)
				continue;
			labels.add(new EquationLabel(labelsText.get(i)));
		}
		this.getChildren().addAll(labels);
	}
	private ArrayList<LabelText> sort(ArrayList<LabelText> labes) {
		return labes;
	}
	public class EquationLabel extends Label {
		
		public EquationLabel(LabelText lt) {
			getStyleClass().add("equationlabel");
			setTextByEquation(lt);
		}

		public void setTextByEquation(LabelText lt) {
			this.setText(String.format(lt.getLp()+". "+"%71s"+"\t"+lt.getAge(), lt.getEq().toStringShort()));
			
		}
	}
	public class LabelText{
		private Equation eq;
		private int lp,age;

		public LabelText(Equation eq, int i, int j) {
			super();
			this.eq = eq;
			this.lp = i;
			this.age = j;
		}

		public Equation getEq() {
			return eq;
		}

		public void setEq(Equation eq) {
			this.eq = eq;
		}

		public int getLp() {
			return lp;
		}

		public void setLp(int lp) {
			this.lp = lp;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
	}
}
