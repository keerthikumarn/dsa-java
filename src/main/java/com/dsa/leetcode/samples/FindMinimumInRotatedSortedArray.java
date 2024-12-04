package com.dsa.leetcode.samples;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMinBSLowerBound(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMinBSLowerBound(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMinBSLowerBound(new int[] { 11, 13, 15, 17 }));

		System.out.println(findMinBruteForceApproach(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMinBruteForceApproach(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMinBruteForceApproach(new int[] { 11, 13, 15, 17 }));
	}

	/** Brute force approach */
	private static int findMinBruteForceApproach(int[] nums) {
		return Arrays.stream(nums).min().getAsInt();
	}

	/* Binary search approach */
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int minNum = nums[0];

		while (left <= right) {
			if (nums[left] < nums[right]) {
				minNum = Math.min(minNum, nums[left]);
				break;
			}
			int midElement = left + (right - left) / 2;
			minNum = Math.min(minNum, nums[midElement]);
			if (nums[midElement] >= nums[left]) {
				left = midElement + 1;
			} else {
				right = midElement - 1;
			}
		}
		return minNum;
	}

	/* Binary search approach - lower bound */
	private static int findMinBSLowerBound(int[] nums) {
		int startNum = 0;
		int endNum = nums.length - 1;
		while (startNum < endNum) {
			int midElement = (startNum + endNum) / 2;
			if (nums[midElement] > nums[endNum]) {
				startNum = midElement + 1;
			} else if (nums[midElement] <= nums[endNum]) {
				endNum = midElement;
			}
		}
		return nums[startNum];
	}

}
