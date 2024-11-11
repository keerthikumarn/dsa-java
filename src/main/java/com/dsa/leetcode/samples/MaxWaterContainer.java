package com.dsa.leetcode.samples;

public class MaxWaterContainer {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 7, 2, 5, 4, 7, 3, 6 }));
		System.out.println(maxAreaTwoPointerApproach(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
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

	/* 2 Pointer Approach */
	private static int maxAreaTwoPointerApproach(int[] heights) {
		int leftPtr = 0;
		int rightPtr = heights.length - 1;
		int maxArea = 0;
		while (leftPtr < rightPtr) {
			System.out.println("heights[leftPtr]: "+heights[leftPtr]+" and heights[rightPtr]: "+ heights[rightPtr]);
			int currArea = (rightPtr - leftPtr) * Math.min(heights[leftPtr], heights[rightPtr]);
			System.out.println("currArea: "+currArea);
			maxArea = Math.max(maxArea, currArea);
			System.out.println("maxArea: "+maxArea);
			if (heights[leftPtr] < heights[rightPtr]) {
				leftPtr = leftPtr + 1;
			} else {
				rightPtr = rightPtr - 1;
			}
		}
		System.out.println("Final Max Area: "+maxArea);
		return maxArea;
	}

}