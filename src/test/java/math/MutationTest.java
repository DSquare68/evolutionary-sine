package math;

import static org.junit.Assert.assertNotEquals;

import java.util.Random;

import org.junit.Test;

import com.daniel.evolutionary_sine.math.Mutation;
import com.daniel.evolutionary_sine.math.MutationType;

public class MutationTest {
	@Test
	public void myOwnClassicMethodTest() {
		double d1 = new Random().nextDouble();
		double d2 = new Mutation(d1, 0.0, MutationType.classic).getNumber1();
		assertNotEquals(d1, d2);
	}

	@Test
	public void crossingOverMethodTest() {
		double d11 = new Random().nextDouble();
		double d21 = new Random().nextDouble();
		Mutation m = new Mutation(d11, d21, MutationType.crossingOver);
		double d12 = m.getNumber1();
		double d22 = m.getNumber2();
		 assertNotEquals(d11,d12);
		 assertNotEquals(d21,d22);
		 
	}
}
