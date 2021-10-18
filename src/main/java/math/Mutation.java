package math;

public class Mutation {
	
	private double value;
	public Mutation(double value, MutationType type) {
		switch(Integer.valueOf(type+"")) {
			case MutationType.classic ->  classicMethod();
			case MutationType.crossingOver ->  crossingOverMethod();
		}
	}
	private Object crossingOverMethod() {
		// TODO Auto-generated method stub
		return null;
	}
	private Object classicMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
