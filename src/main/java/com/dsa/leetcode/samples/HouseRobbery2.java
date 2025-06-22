package com.dsa.leetcode.samples;

public class HouseRobbery2 {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	// linear approach
	private int rob(int[] nums, int start, int end) {
		int prev2 = 0;
		int prev1 = 0;
		for (int idx = start; idx <= end; idx++) {
			int curr = Math.max(prev1, prev2 + nums[idx]);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}
}
