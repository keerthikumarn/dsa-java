package com.dsa.leetcode.samples;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		// dp[i][j] = min distance to convert word1[0..i-1] to word2[0..j-1]
		int[][] dp = new int[m + 1][n + 1];

		// Base cases: converting from/to empty string
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i; // delete all characters from word1
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j; // insert all characters to word1
		}

		// Fill the DP table
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					// Characters match, no operation
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// Either replace, delete or insert
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
							Math.min(dp[i - 1][j], // delete
									dp[i][j - 1] // insert
							));
				}
			}
		}

		return dp[m][n];
	}
}
