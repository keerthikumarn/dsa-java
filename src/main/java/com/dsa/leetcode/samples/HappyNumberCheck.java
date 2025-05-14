package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberCheck {

	/*public static void main(String[] args) {
		System.out.println(isHappy(1111111));
	}*/

	public boolean isHappy(int num) {
		Set<Integer> numSet = new HashSet<>();
		while (num != 1) {
			if (!numSet.add(num)) {
				return false;
			}
			num = nextNumber(num);
		}
		return true;
	}

	private int nextNumber(int num) {
		int totalSum = 0;
		while (num > 0) {
			int digit = num % 10;
			totalSum = totalSum + (digit * digit);
			num = num / 10;
		}
		return totalSum;
	}

}
