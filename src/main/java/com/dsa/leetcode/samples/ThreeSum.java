package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		//List<List<Integer>> list = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		//System.out.println(list.toString());
	}

	/* Brute force approach */
	public List<List<Integer>> threeSum(int[] nums) {
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

	/* HashMap approach */
	public List<List<Integer>> threeSumHashMapApproach(int[] nums) {
		Arrays.sort(nums);
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int iIdx = 0; iIdx < nums.length; iIdx++) {
			count.put(nums[iIdx], count.get(nums[iIdx]) - 1);
			if (iIdx > 0 && nums[iIdx] == nums[iIdx - 1])
				continue;

			for (int jIdx = iIdx + 1; jIdx < nums.length; jIdx++) {
				count.put(nums[jIdx], count.get(nums[jIdx]) - 1);
				if (jIdx > iIdx + 1 && nums[jIdx] == nums[jIdx - 1])
					continue;

				int target = -(nums[iIdx] + nums[jIdx]);
				if (count.getOrDefault(target, 0) > 0) {
					result.add(Arrays.asList(nums[iIdx], nums[jIdx], target));
				}
			}

			for (int kIdx = iIdx + 1; kIdx < nums.length; kIdx++) {
				count.put(nums[kIdx], count.get(nums[kIdx]) + 1);
			}
		}
		return result;
	}

}
