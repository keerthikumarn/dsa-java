package com.dsa.leetcode.samples;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int idx = 0; idx < len; idx++) {
			while (nums[idx] > 0 && nums[idx] <= len && nums[nums[idx] - 1] != nums[idx]) {
				int temp = nums[nums[idx] - 1];
				nums[nums[idx] - 1] = nums[idx];
				nums[idx] = temp;
			}
		}
		for (int idx = 0; idx < len; idx++) {
			if (nums[idx] != idx + 1) {
				return idx + 1;
			}
		}
		return len + 1;
	}
}
