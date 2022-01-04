package com.daniel.evolutionary_sine.engine;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

import com.daniel.evolutionary_sine.EvolutionarySine;
import com.daniel.evolutionary_sine.gui.EquationsPane;
import com.daniel.evolutionary_sine.gui.GraphPane;
import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.Fitness;
import com.daniel.evolutionary_sine.math.Mutation;
import com.daniel.evolutionary_sine.math.MutationType;

import javafx.application.Platform;

public class Engine {
	public static ArrayList<EquationFitness> eqF = new ArrayList<>();
	public Engine() {
		
	}
	public static void start() {
		for(int i=0;i<100;i++)
			eqF.add(new EquationFitness(new Equation(), 2));
		eqF = (ArrayList<EquationFitness>) eqF.stream().sorted(Comparator.comparingDouble(EquationFitness::getFitness)).collect(Collectors.toList());
		try {
		while(true) {
			step();
			updateEquations();
			updateGraph();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void step() {
		Random r = new Random();
		int[] classic= new int [15],crossA= new int[35],crossB= new int[35],sin= new int[35],abc= new int[35];
		for(int i=0;i<classic.length;i++)
			classic[i]=r.nextInt(70)+30;
		for(int i=0;i<crossA.length;i++) {
			crossA[i]=r.nextInt(70)+30;
			crossB[i]=r.nextInt(70)+30;
			if(crossA[i]==crossB[i])
				i=i==0 ? 0:--i ;
			sin[i]=r.nextInt(3);
			abc[i]=r.nextInt(3);
		}
		Mutation m ;
		for(int i :classic) {
			int j= r.nextInt(3);
			int k= r.nextInt(3);
			switch(k) {
				case 0	->  	eqF.get(i).getEquation().getSins()[j].setA(new Mutation(eqF.get(i).getEquation().getSins()[j].getA(),0.0, MutationType.classic).getNumber1());
				case 1	->		eqF.get(i).getEquation().getSins()[j].setB(new Mutation(eqF.get(i).getEquation().getSins()[j].getB(),0.0, MutationType.classic).getNumber1());
				case 	2	-> 	eqF.get(i).getEquation().getSins()[j].setC(new Mutation(eqF.get(i).getEquation().getSins()[j].getC(),0.0, MutationType.classic).getNumber1());
			}
		}
		for(int i=0;i<crossA.length;i++) {
				double a = 0,b = 0;
				switch(abc[i]) {
					case 0 ->  {a = eqF.get(crossA[i]).getEquation().getSins()[sin[i]].getA();
									b = eqF.get(crossB[i]).getEquation().getSins()[sin[i]].getA();}
					case 1 -> { a = eqF.get(crossA[i]).getEquation().getSins()[sin[i]].getB();
									b = eqF.get(crossB[i]).getEquation().getSins()[sin[i]].getB();}
					case 2 ->  {a = eqF.get(crossA[i]).getEquation().getSins()[sin[i]].getC();
									b = eqF.get(crossB[i]).getEquation().getSins()[sin[i]].getC();}
				}
				m= new Mutation(a,b,MutationType.crossingOver);
				switch(abc[i]) {
					case 0 ->  {eqF.get(crossA[i]).getEquation().getSins()[sin[i]].setA(m.getNumber1());
					eqF.get(crossB[i]).getEquation().getSins()[sin[i]].setA(m.getNumber2());}
					case 1 ->  {eqF.get(crossA[i]).getEquation().getSins()[sin[i]].setB(m.getNumber1());
					eqF.get(crossB[i]).getEquation().getSins()[sin[i]].setB(m.getNumber2());}
					case 2 ->  {eqF.get(crossA[i]).getEquation().getSins()[sin[i]].setC(m.getNumber1());
					eqF.get(crossB[i]).getEquation().getSins()[sin[i]].setC(m.getNumber2());}
				}

		}
		eqF.forEach(e->e.setFitness(new Fitness(e.getEquation()).findFitness()));
		eqF = (ArrayList<EquationFitness>) eqF.stream().sorted(Comparator.comparingDouble(EquationFitness::getFitness)).collect(Collectors.toList());
	}
	private static void updateGraph() {
		GraphPane gp =(GraphPane) EvolutionarySine.scene.lookup("#graph-pane");
		Platform.runLater(() -> {gp.draw();});
	}
	static int p=0;
	private static void updateEquations() {
		
		for(EquationFitness ef : eqF) {
			EquationsPane.labelsText.get(eqF.indexOf(ef)).setAge(
					EquationsPane.labelsText.get(eqF.indexOf(ef)).getEq().equals(ef.getEquation()) ? 
					EquationsPane.labelsText.get(eqF.indexOf(ef)).getAge()+1 :
						1);
			EquationsPane.labelsText.get(eqF.indexOf(ef)).setEq( ef.getEquation());
			
		}
			Platform.runLater(() -> {p=0;EquationsPane.labels.forEach(e->e.setTextByEquation(EquationsPane.labelsText.get(p++)));});
		System.out.println(eqF.get(0).getFitness()+"\t"+eqF.get(1).getFitness()+"\t"+eqF.get(20).getFitness()+"\t"+eqF.get(99).getFitness());
	}
}
