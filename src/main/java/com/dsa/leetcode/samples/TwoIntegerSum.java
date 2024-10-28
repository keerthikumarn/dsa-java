package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

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

	// HashMap approach
	private static int[] twoSumHashMapApproach(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int iIdx = 0; iIdx < nums.length; iIdx++) {
			int num = target - nums[iIdx];
			if (map.containsKey(num)) {
				return new int[] { map.get(num), iIdx + 1 };
			}
			map.put(nums[iIdx], iIdx + 1);
		}
		return new int[0];
	}

	// Two Pointer Approach
	private static int[] twoSumTwoPointerApproach(int[] numbers, int target) {
		int leftPtr = 0;
		int rightPtr = numbers.length - 1;
		while (leftPtr < rightPtr) {
			int targetSum = numbers[leftPtr] + numbers[rightPtr];
			if (targetSum > target) {
				rightPtr--;
			} else if (targetSum < target) {
				leftPtr++;
			} else {
				return new int[] { leftPtr + 1, rightPtr + 1 };
			}
		}
		return new int[0];
	}

}
