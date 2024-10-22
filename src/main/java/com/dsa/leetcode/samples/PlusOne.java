package com.dsa.leetcode.samples;

public class PlusOne {

	public static void main(String[] args) {

	}

	private static int[] plusOne(int[] digits) {
		int len = digits.length;
		// Start from the last digit and work backwards
		for (int idx = len - 1; idx >= 0; idx--) {
			if (digits[idx] < 9) {
				digits[idx]++;
				return digits;
			}
			digits[idx] = 0;
		}
		int[] newNum = new int[len + 1];
		newNum[0] = 1;
		return newNum;
	}

}
