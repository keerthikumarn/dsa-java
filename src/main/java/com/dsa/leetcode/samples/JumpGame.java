package com.dsa.leetcode.samples;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 2, 3, 1, 1, 4 };
		int[] nums2 = new int[] { 0 };
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
	}

	private static boolean canJump(int[] nums) {
		if (nums.length == 0 || nums.length == 1 && nums[0] == 0) {
			return true;
		}
		int maxReachable = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			maxReachable = Math.max(maxReachable, nums[idx] + idx);
			if (nums[idx] == 0) {
				if (idx + 1 == nums.length) {
					return true;
				}
				if (maxReachable == idx) {
					return false;
				}
			}
		}
		return true;
	}

}
