package com.dsa.leetcode.samples;

public class CountingBits {

	public static void main(String[] args) {
		System.out.println(countBits(4));
	}

	private static int[] countBits(int n) {
		int[] result = new int[n + 1];
		int offSet = 1;
		for (int idx = 1; idx <= n; idx++) {
			if (offSet * 2 == idx) {
				offSet = idx;
			}
			result[idx] = result[idx - offSet] + 1;
		}
		return result;
	}

}
