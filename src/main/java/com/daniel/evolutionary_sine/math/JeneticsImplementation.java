package com.daniel.evolutionary_sine.math;

import io.jenetics.BitChromosome;
import io.jenetics.DoubleChromosome;
import io.jenetics.DoubleGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

public class JeneticsImplementation {
	// 2 . ) D e fi n it i on of the f i t n e s s function .
			 private static  double eval ( final Genotype<DoubleGene> gt ) {
			 return gt . chromosome ()
			 .as( DoubleChromosome.class)
			 .max();
			 }
	public static Equation calculate() {
		Genotype<DoubleGene> genotype = Genotype.of(
				 DoubleChromosome.of( 0.0 , 1.0 , 8)
				 );
		 // 1 . ) Define the genotype ( factory ) s u i t a b l e
		 // f o r the problem .
		 final Factory<Genotype<DoubleGene>> gtf =
		 Genotype.of( DoubleChromosome.of (10 , 0.5) ) ;
		
		 // 3 . ) Create the execution environment .
		final Engine<DoubleGene , Double> engine = Engine
		.builder (JeneticsImplementation::eval , gtf )
		.build () ;
		
		 // 4 . ) Start the execution ( evolution ) and
		 // c o l l e c t the r e s u l t .
		 final Genotype<DoubleGene> result = engine.stream ()
		 .limit(100)
		 .collect(EvolutionResult.toBestGenotype () ) ;
		return null;
	}
}
