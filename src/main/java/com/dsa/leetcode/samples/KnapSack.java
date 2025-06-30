package com.dsa.leetcode.samples;

public class KnapSack {

	public int knapsack(int W, int[] weight, int[] value, int n) {
		int[][] dp = new int[n + 1][W + 1];
		for (int iIdx = 0; iIdx <= n; iIdx++) {
			for (int wIdx = 0; wIdx <= W; wIdx++) {
				if (iIdx == 0 || wIdx == 0) {
					dp[iIdx][wIdx] = 0;
				} else if (weight[iIdx - 1] <= wIdx) {
					dp[iIdx][wIdx] = Math.max(dp[iIdx - 1][wIdx],
							dp[iIdx - 1][wIdx - weight[iIdx - 1]] + value[iIdx - 1]);
				} else {
					dp[iIdx][wIdx] = dp[iIdx - 1][wIdx];
				}
			}
		}
		return dp[n][W];
	}
}
