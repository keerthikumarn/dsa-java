package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinimumTotalOfTriangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3));
		System.out.println(minimumTotal(triangle));
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		int[] dp = IntStream.range(0, len).map(idx -> triangle.get(len - 1).get(idx)).toArray();
		for (int iIdx = len - 2; iIdx >= 0; iIdx--) {
			for (int jIdx = 0; jIdx < triangle.get(iIdx).size(); jIdx++) {
				dp[jIdx] = Math.min(dp[jIdx], dp[jIdx + 1]) + triangle.get(iIdx).get(jIdx);
			}
		}
		return dp[0];
	}

}