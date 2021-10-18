package math;

import java.util.Random;

/**
 * @author Daniel
 *		y=A1sin(B1x-C1)+A2sin(B2x-C2)+A3sin(B3x-C3)
 */
public class Equation {
	Sine[] sins = new Sine[3];
	
	public Equation() {
		random();
	}
	public Equation(Sine a, Sine b, Sine c) {
		sins[0]=a;
		sins[1]=b;
		sins[2]=c;
	}
	public void random() {
		Random r = new Random();
		sins[0]= new Sine(-10+20*r.nextDouble(),-Math.PI+2*Math.PI*r.nextDouble(),2*Math.PI*r.nextDouble());
		sins[1]= new Sine(-10+20*r.nextDouble(),-Math.PI+2*Math.PI*r.nextDouble(),2*Math.PI*r.nextDouble());
		sins[2]= new Sine(-10+20*r.nextDouble(),-Math.PI+2*Math.PI*r.nextDouble(),2*Math.PI*r.nextDouble());
	}
	public double getY(double x) {
		return sins[0].getResult(x)+sins[1].getResult(x)+sins[2].getResult(x);
	}
	@Override
	public String toString() {
		double x = new Random().nextDouble();
		sins[0].setX(x);sins[1].setX(x);sins[2].setX(x);
		return sins[0].toString()+"+"+sins[1].toString()+"+"+sins[2].toString()+"\ty:"+getY(x);
	}
	/**
	 *  Asin(Bx-C)
	 */
	public class Sine{
		double A,B,C,x;
		
		public Sine(double a, double b, double c) {
			super();
			A = a;
			B = b;
			C = c;
		}

		public double getA() {
			return A;
		}

		public void setA(double a) {
			A = a;
		}

		public double getB() {
			return B;
		}

		public void setB(double b) {
			B = b;
		}

		public double getC() {
			return C;
		}

		public void setC(double c) {
			C = c;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getResult(double x) {
			return A*Math.sin(B*x-C);
		}
		@Override
		public String toString() {
			return A+"sin("+B+"*"+x+"-"+C+")";
		}
	}
}
