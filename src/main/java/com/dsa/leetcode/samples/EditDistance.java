package com.dsa.leetcode.samples;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int iIdx = 0; iIdx <= m; iIdx++) {
			dp[iIdx][0] = iIdx;
		}

		for (int jIdx = 0; jIdx <= m; jIdx++) {
			dp[0][jIdx] = jIdx;
		}

		for (int iIdx = 1; iIdx <= m; iIdx++) {
			for (int jIdx = 1; jIdx <= n; jIdx++) {
				if (word1.charAt(iIdx - 1) == word2.charAt(jIdx - 1)) {
					dp[iIdx][jIdx] = dp[iIdx - 1][jIdx - 1];
				} else {
					dp[iIdx][jIdx] = Math.min(Math.min(dp[iIdx - 1][jIdx], dp[iIdx][jIdx - 1]), dp[iIdx - 1][jIdx - 1])
							+ 1;
				}
			}
		}
		return dp[m][n];
	}
}
