package com.dynamicprogramming.samples;

import java.util.function.Function;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(9));
		System.out.println(fibonacci(7));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(11));

		Function<Integer, Integer> fibonacci = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer num) {
                if (num <= 2) {
                    return 1;
                }
                return this.apply(num - 1) + this.apply(num - 2);
            }
        };
        int result = fibonacci.apply(12);
        System.out.println("Fibonacci of 12: " + result);
	}

	private static int fibonacci(int num) {
		if (num <= 2) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

}
