package com.dsa.leetcode.samples;

public class AdditionWithoutOperators {

	public static void main(String[] args) {
		System.out.println(getSum(5, 3));
		System.out.println(getSum(4, -7));
	}

	private static int getSum(int a, int b) {
		while (b != 0) {
			int tempNum = a ^ b;
			b = (a & b) << 1;
			a = tempNum;
		}
		return a;
	}

}
