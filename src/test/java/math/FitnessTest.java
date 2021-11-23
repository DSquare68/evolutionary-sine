package math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.daniel.evolutionary_sine.EvolutionarySine;
import com.daniel.evolutionary_sine.EvolutionarySine.Points;
import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.Fitness;
import com.daniel.evolutionary_sine.math.Equation.Sine;

public class FitnessTest {
	Points p = new EvolutionarySine(). new Points();
	{	
		p.getPoints().add(new EvolutionarySine().new Point(1.2,-0.15));
		p.getPoints().add(new EvolutionarySine().new Point(2.5,0.4));
		p.getPoints().add(new EvolutionarySine().new Point(3.0,2));
		p.getPoints().add(new EvolutionarySine().new Point(4.0,1));
		p.getPoints().add(new EvolutionarySine().new Point(5.0,0.05));
	}
	private Fitness f= new Fitness(p,new Equation(new Equation().new Sine(0.9,0.3,0.4), new Equation().new Sine(1.5,0.7,0.8), new Equation().new Sine(0.7,0.05,0.9)));
	
	@Test
	public void testFindFitness() {
		assertEquals(0.13,f.findFitness(),0.01);
	}
}
