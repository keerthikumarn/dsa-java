package com.dsa.leetcode.samples;

public class Celebrity {
	public int celebrity(int[][] mat) {
		int n = mat.length;
		int[] indegree = new int[n];
		int[] outdegree = new int[n];

		for (int iIdx = 0; iIdx < n; iIdx++) {
			for (int jIdx = 0; jIdx < n; jIdx++) {
				int x = mat[iIdx][jIdx];
				// set the degrees
				outdegree[iIdx] += x;
				indegree[jIdx] += x;
			}
		}

		for (int idx = 0; idx < n; idx++)
			if (indegree[idx] == n - 1 && outdegree[idx] == 0) {
				return idx;
			}
		return -1;
	}
}