package com.dsa.leetcode.samples;

public class FactorialTrailingZeros {
	//private static Map<Integer, Double> memoDict = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(trailingZeroes(30));
		System.out.println(trailingZeroes(13));
		System.out.println(trailingZeroes(1574));
	}

	private static int trailingZeroes(int n) {
		int trailingZeroes = 0;
		while (n >= 5) {
			n = n / 5;
			trailingZeroes = trailingZeroes + n;
		}
		return trailingZeroes;
	}

	/*
	 * public static int trailingZeroes(int factorialNum) { double factorial =
	 * factorialCount(factorialNum); int count = 0;
	 * System.out.println("Factorial : " + factorial); while (factorial > 0) {
	 * double rem = factorial % 10; if (rem == 0) { count++; factorial /= 10; } else
	 * { break; } } return count; }
	 * 
	 * private static double factorialCount(int n) { double factorial = 1; if (n <=
	 * 1) { return 1; } factorial = n * factorialCount(n - 1); memoDict.put(n,
	 * factorial); return factorial; }
	 */

}
