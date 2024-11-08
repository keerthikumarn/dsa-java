package com.dsa.leetcode.samples;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 11, 13, 15, 17 }));
	}

	private static int findMin(int[] nums) {
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