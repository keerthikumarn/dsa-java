package com.dsa.binary.operators;

public class BitwiseComplement {

	public static void main(String[] args) {
		int num1 = 6, num2 = -2;

		System.out.println("First Number = " + num1);
		System.out.println("Second Number = " + num2);

		System.out.println(num1 + "'s bitwise complement = " + ~num1);
		System.out.println(num2 + "'s bitwise complement = " + ~num2);
	}

}
