package com.dsa.leetcode.samples;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int max = 0;
		for (int idx = 0; idx < rows; idx++) {
			for (int jdx = 0; jdx < cols; jdx++) {
				if (matrix[idx][jdx] == '1') {
					if (idx == 0 || jdx == 0) {
						dp[idx][jdx] = 1;
					} else {
						dp[idx][jdx] = Math.min(dp[idx - 1][jdx], Math.min(dp[idx][jdx - 1], dp[idx - 1][jdx - 1])) + 1;
					}
					max = Math.max(max, dp[idx][jdx]);
				}
			}
		}
		return max * max;
	}
}
