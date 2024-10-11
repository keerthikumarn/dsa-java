package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumCheckInArray {

	public static void main(String[] args) {
		System.out.println(areThereAnyDuplicateNum(new int[] { 1, 3, -2, 3 }));
	}

	private static boolean areThereAnyDuplicateNum(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			if (numSet.contains(num)) {
				return true;
			}
			numSet.add(num);
		}
		return false;
	}

}
