package com.daniel.evolutionary_sine.math;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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
		String num1=String.valueOf(valueA),num2=String.valueOf(valueB);
		if(num1.contains("E"))
			num1= num1.substring(0, num1.indexOf('E')-2);
		if(num2.contains("E"))
			num2= num2.substring(0, num2.indexOf('E')-2);
		Set<Integer> s = new TreeSet<>();
		for(int i=0;s.size()<n;i++) {
			int k=new Random().nextInt(Math.min(num1.length()-1,num2.length()-1));
			if(k==num1.indexOf('.')||k==num2.indexOf('.'))
				continue;
			s.add(k);
		}
		for(int a : s) {
			//System.out.println(a);
			char c1 = num1.charAt(a), c2 = num2.charAt(a);
			num1=String.valueOf(switchDigit(a,c2, num1));
			num2=String.valueOf(switchDigit(a,c1, num2));
		}
		if(num1.contains("E"))
			num1= num1.substring(0, num1.indexOf('E')-2);
		if(num2.contains("E"))
			num2= num2.substring(0, num2.indexOf('E')-2);
		valueA=Double.valueOf(num1);
		valueB=Double.valueOf(num2);
	}
	private void myOwnClassicMethod() {
		Random r = new Random();
		String num = String.valueOf(valueA);
		if(num.contains("E"))
			num= num.substring(0, num.indexOf('E')-2);
		int point = num.indexOf('.');
		int a=r.nextInt(num.length()-1),b=r.nextInt(num.length()-1),x1=r.nextInt(10),x2=r.nextInt(10);
		while((a==point||b==point)&&a<16&&b<16) {
			a=r.nextInt(num.length()-1);
			b=r.nextInt(num.length()-1);
		}
		valueA=switchDigit(a, x1, String.valueOf(switchDigit(b,x2,num)));
	}
	
	private double switchDigit(int a,int x1,String num) {
		String beg = null,end = null;
		if(num.length()<a)
			return Double.valueOf(num)+x1*Math.pow(10, -a);
		if(a==0) {
			int indexOfDecimal = num.indexOf(".");
			return Double.valueOf(num.substring(indexOfDecimal))+x1;
		}
		beg= num.substring(0,  a-1 );
		end=num.substring(a+1);
		return Double.valueOf(beg+x1+end);
	}
}
