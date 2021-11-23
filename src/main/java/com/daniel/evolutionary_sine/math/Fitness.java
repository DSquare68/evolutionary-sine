package com.daniel.evolutionary_sine.math;

import java.util.ArrayList;
import java.util.Comparator;

import com.daniel.evolutionary_sine.EvolutionarySine.Point;
import com.daniel.evolutionary_sine.EvolutionarySine.Points;

/**
 * @author Daniel
 *
 */
public class Fitness {
	private Equation eq;
	private Points p;
	ArrayList<Double> roots = new ArrayList<>();
	
	public Fitness(Points p, Equation eq) {
		this.p =p;
		this.eq=eq;
	}
	private double getDistance(Point p,double x1) {
		return Math.sqrt(Math.pow(p.x-x1,2)+ Math.pow(p.y-eq.getY(x1),2));
	}
/**
 * 		finding point x1 when distance from x0 is th nearest for eq.getY(x0)
 * @return point x1
 */
	double r=Double.MAX_VALUE;
	private double findPoint(Point p) {
		roots = new ArrayList<>();
		final double STEP=0.01;
		double[] points = new double[2];
		double[] values = new double[4];
		points[0]=p.x;
		points[1]=p.x;
		values[0] = getDerivativeFromDistance(p,points[0]);
		values[1] =values[0];
		values[2] = getDerivativeFromDistance(p,points[1]);
		values[3] =values[2];
		points[0]-=STEP;
		points[1]+=STEP;
		while((Math.abs(points[1]-p.x))<getDistance(p, r)||(Math.abs(points[0]-p.x))<getDistance(p,r)) {
			values[0] = getDerivativeFromDistance(p,points[0]);
			values[2] =getDerivativeFromDistance(p,points[1]);
			if(values[0]*values[1]<0) {
				values[1] = values[0];
				roots.add(points[0]);
			}
			if(values[2]*values[3]<0) {
				values[3] =values [2];
				roots.add(points[1]);
			}
			points[0]-=STEP;
			points[1]+=STEP;
			if(roots.size()>0)
				r = roots.stream().mapToDouble(d->d).min().orElse(Double.MAX_VALUE);
			
			
		}
		return r;
	}
	public double findFitness() {
		double median= p.getPoints().stream().mapToDouble(p->getDistance(p,findPoint(p))).sum()/p.getPoints().size();
		return p.getPoints().stream().mapToDouble(p->Math.abs(median -getDistance(p,findPoint(p)))).sum()/p.getPoints().size();
	}
	
	/**
	 *  2x1-2x+f^2(x1)'-2f(x)*f(x1)')=y
	 * @return value of y
	 */
	private double getDerivativeFromDistance(Point p,double x1) {
		return 2*x1-2*p.x+eq.getSquereDerivative(x1)-2*(p.y*eq.getDerivative(x1));
	}
}
