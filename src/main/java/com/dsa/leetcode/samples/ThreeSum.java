package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		List<List<Integer>> list = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println(list.toString());
	}

	/* Brute force approach */
	private static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		// sort the nums
		Arrays.sort(nums);
		int arrlen = nums.length;
		for (int iIdx = 0; iIdx < arrlen; iIdx++) {
			for (int jIdx = iIdx + 1; jIdx < arrlen; jIdx++) {
				for (int kIdx = jIdx + 1; kIdx < arrlen; kIdx++) {
					if (nums[iIdx] + nums[jIdx] + nums[kIdx] == 0) {
						List<Integer> tempList = Arrays.asList(nums[iIdx], nums[jIdx], nums[kIdx]);
						result.add(tempList);
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

}
