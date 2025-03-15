package com.dsa.leetcode.samples;

public class RemoveDuplicatesFromArray {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}

		int iIdx = 1;

		for (int jIdx = 1; jIdx < len; jIdx++) {
			if (nums[jIdx] != nums[jIdx - 1]) {
				nums[iIdx] = nums[jIdx];
				iIdx++;
			}
		}
		return iIdx;
	}
}
