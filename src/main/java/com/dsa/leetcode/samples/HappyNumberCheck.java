package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberCheck {

	public static void main(String[] args) {
		System.out.println(isHappy(100));
		System.out.println(isHappy(2));
		System.out.println(isHappy(120));
	}

	private static boolean isHappy(int num) {
		Set<Integer> numSet = new HashSet<>();
		while (num != 1) {
			if (!numSet.add(num)) {
				return false;
			}
			num = nextNumber(num);
		}
		return true;
	}

	private static int nextNumber(int num) {
		/*
		 * int totalSum = 0; while (num > 0) { int digit = num % 10; totalSum = totalSum
		 * + (digit * digit); num = num / 10; } return totalSum;
		 */
		return String.valueOf(num).chars().map(Character::getNumericValue).map(digit -> digit * digit).sum();
	}

}
