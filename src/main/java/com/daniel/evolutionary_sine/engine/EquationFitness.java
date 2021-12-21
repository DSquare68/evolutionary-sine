package com.daniel.evolutionary_sine.engine;

import com.daniel.evolutionary_sine.math.Equation;

public class EquationFitness{
	private Equation eq;
	private double fitness;
	public EquationFitness(Equation eq, double f) {
		this.eq=eq;
		this.fitness=f;
	}
	public Equation getEquation() {
		return eq;
	}
	public void setEquastion(Equation eq) {
		this.eq=eq;
	}
	public void  setFitness(double f) {
		this.fitness=f;
	}
	public double  getFitness() {
		return this.fitness;
	}
}
