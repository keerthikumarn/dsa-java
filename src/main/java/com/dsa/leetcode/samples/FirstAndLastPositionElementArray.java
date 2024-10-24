package com.dsa.leetcode.samples;

public class FirstAndLastPositionElementArray {

	public static void main(String[] args) {
		System.out.println(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
		System.out.println(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
	}

	private static int[] searchRange(int[] nums, int target) {
		int start = -1;
		int end = -1;
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] == target) {
				if (start == -1) {
					start = idx;
				}
				end = idx;
			}
		}
		return new int[] { start, end };
	}

}
