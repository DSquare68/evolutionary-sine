package math;

import java.util.Random;

public class Mutation {
	
	private double valueA,valueB,result;
	public Mutation(double valueA,double valueB, int type) {
		this.valueA=valueA;
		this.valueB=valueB;
		switch(Integer.valueOf(type+"")) {
			case MutationType.classic -> myOwnClassicMethod();// classicMethod();
			case MutationType.crossingOver ->  crossingOverMethod();
		}
	}
	public double getNumber1() {
		return this.valueA;
	}
	public double getNumber2() {
		return this.valueB;
	}
	private void crossingOverMethod() {
		int n = new Random().nextInt(3)+3;
		for(int i=0;i<n;i++) {
			String num1=String.valueOf(valueA),num2=String.valueOf(valueB);
			int a=new Random().nextInt(Math.min(num1.length()-1,num2.length()-1));
			while(a==num1.indexOf('.')&&a<num2.length()&&a>15)
				a=new Random().nextInt(Math.min(num1.length()-1,num2.length()-1));
			char c1 = num1.charAt(a), c2 = num2.charAt(a);
			valueA=switchDigit(a,c2, num1);
			valueB=switchDigit(a,c1, num2);
		}
	}
	private void myOwnClassicMethod() {
		Random r = new Random();
		String num = String.valueOf(valueA);
		int point = num.indexOf('.');
		int a=r.nextInt(num.length()-1),b=r.nextInt(num.length()-1),x1=r.nextInt(10),x2=r.nextInt(10);
		while((a==point||b==point)&&a<16&&b<16) {
			a=r.nextInt(num.length()-1);
			b=r.nextInt(num.length()-1);
		}
		valueA=switchDigit(a, x1, String.valueOf(switchDigit(b,x2,num)));
	}
	
	private double switchDigit(int a,int x1,String num) {
		String beg,end;
		beg= num.substring(0, a==0 ? a : a-1 );
		end=num.substring(a);
		return Double.valueOf(beg+a+end);
	}
}
