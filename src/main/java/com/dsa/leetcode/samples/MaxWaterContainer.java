package com.dsa.leetcode.samples;

public class MaxWaterContainer {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 7, 2, 5, 4, 7, 3, 6 }));
	}

	/* Brute Force Approach */
	private static int maxArea(int[] heights) {
		int maxArea = 0;
		for (int iIdx = 0; iIdx < heights.length; iIdx++) {
			for (int jIdx = iIdx + 1; jIdx < heights.length; jIdx++) {
				maxArea = Math.max(maxArea, Math.min(heights[iIdx], heights[jIdx]) * (jIdx - iIdx));
			}
		}
		return maxArea;
	}

}