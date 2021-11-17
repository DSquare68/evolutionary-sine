package math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.Equation.Sine;

public class EquationTest{

	private Equation e;
	private double A[]= new double[3],B[]= new double[3],C[]= new double[3],x=Math.PI/4;
	
	@Before
	public void init() {
		e = new Equation();
	}
	
	//@Test
	public void sineTest() {
		System.out.println(e.toString());
		Random r = new Random();
		e = new Equation();
		//assertEquals(e.getY(x), A[0]*Math.sin(B[0]*x-C[0])+A[1]*Math.sin(B[1]*x-C[1])+A[2]*Math.sin(B[2]*x-C[2]), 0.01);
	}
	
	//@Test
	public void derivativeTest() {
		System.out.println(e.toString()+"  pochodna PI/7:  "+e.getDerivative(Math.PI/7));
		e = new Equation(e.new Sine(0.96754,0.5432,0.764), e.new Sine(0.82542,0.2445,0.4563), e.new Sine(0.16423,7.35654,3.846));
		System.out.println(e.toString()+"  pochodna PI/7:  "+e.getDerivative(Math.PI/7));
		assertEquals(1.6790,e.getDerivative(Math.PI/7), 0.001);
	}
	
		@Test
		public void squereDerivativeTest() {
			System.out.println(e.toString()+"  pochodna PI/7:  "+e.getDerivative(Math.PI/7));
			e = new Equation(e.new Sine(0.967,0.543,0.76), e.new Sine(0.825,0.244,0.45), e.new Sine(0.164,7.35,3.84));
			System.out.println(e.toString()+"  pochodna PI/7:  "+e.getSquereDerivative(Math.PI/7));
			assertEquals( -2.8163,e.getSquereDerivative(Math.PI/7),0.004);
		}
}
