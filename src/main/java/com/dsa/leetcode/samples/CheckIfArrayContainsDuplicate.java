package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayContainsDuplicate {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 3 };
		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println(hasDuplicate(nums1));
		System.out.println(hasDuplicate(nums2));
	}

	private static boolean hasDuplicate(int[] nums) {
		boolean hasDuplicate = false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int idx = 0; idx < nums.length; idx++) {
			if (map.containsKey(nums[idx])) {
				hasDuplicate = true;
			} else {
				map.put(nums[idx], idx);
			}
		}
		return hasDuplicate;
	}

}
