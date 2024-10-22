package com.dsa.leetcode.samples;

public class TwoIntegerSum {

	public static void main(String[] args) {

	}

	// Brute force approach
	private static int[] twoSum(int[] nums, int target) {
		for (int iIdx = 0; iIdx < nums.length; iIdx++) {
			for (int jIdx = 0; jIdx < nums.length; jIdx++) {
				if (nums[iIdx] + nums[jIdx] == target) {
					return new int[] { iIdx + 1, jIdx + 1 };
				}
			}
		}
		return new int[0];
	}

}
