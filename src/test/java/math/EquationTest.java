package math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.daniel.evolutionary_sine.math.Equation;

public class EquationTest{

	private Equation e;
	private double A[]= new double[3],B[]= new double[3],C[]= new double[3],x=Math.PI/4;
	
	@Before
	public void init() {
		e = new Equation();
	}
	
	@Test
	public void sineTest() {
		System.out.println(e.toString());
		Random r = new Random();
		e = new Equation();
		A[0]=e.sins[0].getA();		B[0]=e.sins[0].getB();	C[0]=e.sins[0].getC();
		A[1]=e.sins[1].getA();		B[1]=e.sins[1].getB();	C[1]=e.sins[1].getC();
		A[2]=e.sins[2].getA();		B[2]=e.sins[2].getB();	C[2]=e.sins[2].getC();
		assertEquals(e.getY(x), A[0]*Math.sin(B[0]*x-C[0])+A[1]*Math.sin(B[1]*x-C[1])+A[2]*Math.sin(B[2]*x-C[2]), 0.01);
	}
	
	
}
