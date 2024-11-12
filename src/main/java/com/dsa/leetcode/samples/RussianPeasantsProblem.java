package com.dsa.leetcode.samples;

public class RussianPeasantsProblem {

	public static void main(String[] args) {
		System.out.println(russianPeasants(12, 15));
	}

	private static int russianPeasants(int a, int b) {
		int num1 = a;
		int num2 = b;
		int russianPeasants = 0;
		while (num2 > 0) {
			if (num1 % 2 == 1) {
				russianPeasants = russianPeasants + num2;
			}
			num2 = num2 << 1;
			num1 = num1 >> 1;
			System.out.println("num1 >> 1 : "+num1+" and num2 << 1 : "+num2);
		}
		return russianPeasants;
	}

}
