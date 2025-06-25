package com.dsa.leetcode.samples;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
		int[] dp = new int[length];
		int maxLength = 1;
		for (int iIdx = 0; iIdx < length; iIdx++) {
			dp[iIdx] = 1; // Each element is an increasing
			for (int jIdx = 0; jIdx < iIdx; jIdx++) {
				if (nums[iIdx] > nums[jIdx]) {
					dp[iIdx] = Math.max(dp[iIdx], dp[jIdx] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[iIdx]);
		}
		return maxLength;
	}

}
