package com.dsa.binary.operators;

public class ConditionalOperators {

	public static void main(String[] args) {
		int num1;
		int num2;
		num1 = 20;

		num2 = (num1 > 5) ? 2 : 10;
		System.out.println("num2 = " + num2);

		num2 = (num1 == 25) ? 20 : 30;
		System.out.println("num2 = " + num2);
	}

}
