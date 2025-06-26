package com.dsa.leetcode.samples;

public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		if (totalSum % 2 != 0) {
			return false; // if total sum is odd, cannot partition into two equal subsets
		}
		int target = totalSum / 2;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true; // base case: zero sum is always achievable]
		for (int num : nums) {
			for (int j = target; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
			}
		}
		return dp[target];
	}

}
