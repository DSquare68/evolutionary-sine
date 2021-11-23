package math;

import org.junit.Test;

import com.daniel.evolutionary_sine.math.Equation;
import com.daniel.evolutionary_sine.math.JeneticsImplementation;

import io.jenetics.DoubleChromosome;
import io.jenetics.DoubleGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

public class JeneticsImplementationTest {
	final static double X =0.345;
	// 2 . ) D e fi n it i on of the f i t n e s s function .
	 private static  double eval ( final Genotype<DoubleGene> gt ) {
	 return gt.chromosome().get(0).doubleValue()*Math.sin(gt.chromosome ().get(1).doubleValue()*X-gt.chromosome().get(2).doubleValue());
	 }
	 @Test
public void calculate() {
// 1 . ) Define the genotype ( factory ) s u i t a b l e
// f o r the problem .
final Factory<Genotype<DoubleGene>> gtf =
Genotype.of( DoubleChromosome.of (-5.0 , 5.0 , 3) ) ;

// 3 . ) Create the execution environment .
final Engine<DoubleGene , Double> engine = Engine
.builder (JeneticsImplementationTest::eval , gtf )
.build () ;

// 4 . ) Start the execution ( evolution ) and
// c o l l e c t the r e s u l t .
final Genotype<DoubleGene> result = engine.stream ()
.limit(100)
.collect(EvolutionResult.toBestGenotype () ) ;
System.out.println(result+"lol");
}
}
