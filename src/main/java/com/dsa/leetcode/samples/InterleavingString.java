package com.dsa.leetcode.samples;

public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		// Init the 1st column
		for (int iIdx = 1; iIdx <= m; iIdx++) {
			dp[iIdx][0] = dp[iIdx - 1][0] && s1.charAt(iIdx - 1) == s3.charAt(iIdx - 1);
		}

		// Init the first row
		for (int jIdx = 1; jIdx <= n; jIdx++) {
			dp[0][jIdx] = dp[0][jIdx - 1] && s2.charAt(jIdx - 1) == s3.charAt(jIdx - 1);
		}

		// Fill the dp table
		for (int iIdx = 1; iIdx <= m; iIdx++) {
			for (int jIdx = 1; jIdx <= n; jIdx++) {
				dp[iIdx][jIdx] = (dp[iIdx - 1][jIdx] && s1.charAt(iIdx - 1) == s3.charAt(iIdx + jIdx - 1))
						|| (dp[iIdx][jIdx - 1] && s2.charAt(jIdx - 1) == s3.charAt(iIdx + jIdx - 1));
			}
		}
		return dp[m][n];
	}
}
