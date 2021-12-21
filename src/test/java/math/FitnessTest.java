package math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.Fitness;
import com.daniel.evolutionary_sine.math.Points;

import javafx.geometry.Point2D; 

public class FitnessTest {
	Points p = new Points();
	{	
		p.getPoints().add(new Point2D(1.2,-0.15));
		p.getPoints().add(new Point2D(2.5,0.4));
		p.getPoints().add(new Point2D(3.0,2));
		p.getPoints().add(new Point2D(4.0,1));
		p.getPoints().add(new Point2D(5.0,0.05));
	}
	private Fitness f= new Fitness(new Equation(new Equation().new Sine(0.9,0.3,0.4), new Equation().new Sine(1.5,0.7,0.8), new Equation().new Sine(0.7,0.05,0.9)));
	
	@Test
	public void testFindFitness() {
		assertEquals(0.13,f.findFitness(),0.01);
	}
}
