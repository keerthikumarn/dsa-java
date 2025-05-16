package com.dsa.leetcode.samples;

public class JumpGame {

	/*public static void main(String[] args) {
		int[] nums1 = new int[] { 2, 3, 1, 1, 4 };
		int[] nums2 = new int[] { 0 };
		int[] nums3 = new int[] { 3, 4, 3, 2, 5, 4, 3 };
		int[] nums4 = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
		System.out.println(jump(nums1));
		System.out.println(jump(nums3));
		System.out.println(jump(nums4));
	}*/

	public boolean canJump(int[] nums) {
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

	public int jump(int[] nums) {
		int len = nums.length;
		if (len == 0 || len == 1 || nums[0] == 0) {
			return 0;
		}
		int currEnd = 0;
		int lastElement = 0;
		int noOfJumpsRequired = 0;
		for (int idx = 0; idx < len - 1; idx++) {
			System.out.println("Index = " + idx+ " ==== value: " + nums[idx]);
			lastElement = Math.max(lastElement, nums[idx] + idx);
			if (currEnd == idx) {
				noOfJumpsRequired++;
				currEnd = lastElement;
				if (currEnd >= len - 1) {
					break;
				}
			}
		}
		return noOfJumpsRequired;
	}

}
