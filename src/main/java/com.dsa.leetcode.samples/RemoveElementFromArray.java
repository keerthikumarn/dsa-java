package com.leetcode.samples;

public class RemoveElementFromArray {

	public static void main(String[] args) {
		int[] nums1 = { 3, 2, 2, 3 };
		int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		System.out.println(removeElement(nums1, 2));
		System.out.println(removeElement(nums2, 2));
	}

	private static int removeElement(int[] nums, int val) {
		int deleteNumCountIdx = 0; // denotes "K"
		if (nums.length <= 0) {
			return 0;
		}
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] != val) {
				nums[deleteNumCountIdx] = nums[idx];
				deleteNumCountIdx++;
			}
		}
		return deleteNumCountIdx;
	}

	/**
	 * 3, 2, 2, 3 nums[0] = 3, nums[1] = 2, nums[2]= 2, nums[3] = 3 3!=2 nums[0] = 3
	 * // deleteNumCountIdx == 1 2 == 2; // deleteNumCountIdx == 1 2 == 2; //
	 * deleteNumCountIdx == 1 3 != 2 ; // deleteNumCountIdx == 2 nums[1] = 3
	 * 
	 */

}