package com.daniel.evolutionary_sine.math;

import java.util.ArrayList;
import java.util.Comparator;

import com.daniel.evolutionary_sine.math.Points;

import javafx.geometry.Point2D;

/**
 * @author Daniel
 *
 */
public class Fitness {
	private Equation eq;
	private ArrayList<Point2D> p =Points.getPoints();;
	ArrayList<Double> roots = new ArrayList<>();
	
	public Fitness(Equation eq) {
		this.eq=eq;
	}
	private double getDistance(Point2D p,double x1) {
		return Math.sqrt(Math.pow(p.getX()-x1,2)+ Math.pow(p.getY()-eq.getY(x1),2));
	}
/**
 * 		finding point x1 when distance from x0 is th nearest for eq.getY(x0)
 * @return point x1
 */
	double r=30;
	private double findPoint(Point2D p) {
		roots = new ArrayList<>();
		final double STEP=0.01;
		double[] points = new double[2];
		double[] values = new double[4];
		points[0]=p.getX();
		points[1]=p.getX();
		values[0] = getDerivativeFromDistance(p,points[0]);
		values[1] =values[0];
		values[2] = getDerivativeFromDistance(p,points[1]);
		values[3] =values[2];
		points[0]-=STEP;
		points[1]+=STEP;
		while((Math.abs(points[1]-p.getX()))<getDistance(p, r)||(Math.abs(points[0]-p.getX()))<getDistance(p,r)) {
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
				r = roots.stream().mapToDouble(d->d).min().getAsDouble();
		}
		return r;
	}
	public double findFitness() {
		double median= p.stream().mapToDouble(p->getDistance(p,findPoint(p))).sum()/p.size();
		 Double d =p.stream().mapToDouble(p->Math.abs(median -getDistance(p,findPoint(p)))).sum()/p.size();
		 return d;
	}
	
	/**
	 *  2x1-2x+f^2(x1)'-2f(x)*f(x1)')=y
	 * @return value of y
	 */
	private double getDerivativeFromDistance(Point2D p,double x1) {
		return 2*x1-2*p.getX()+eq.getSquereDerivative(x1)-2*(p.getY()*eq.getDerivative(x1));
	}
}
