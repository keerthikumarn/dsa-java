package com.dynamicprogramming.samples;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(9));
	}

	private static int fibonacci(int num) {
		if (num <= 2) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

}
