package com.dsa.leetcode.samples;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums1, 5));
		System.out.println(searchInsert(nums1, 2));
		System.out.println(searchInsert(nums1, 7));
	}

	private static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int numCount = 0;
		for (int idx = 0; idx < len; idx++) {
			if (nums[idx] == target) {
				return idx;
			}
			if (target > nums[idx]) {
				numCount++;
			}
		}
		return numCount;
	}

}