package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		traceBack(result, new ArrayList<>(), nums);
		return result;
	}

	private static void traceBack(List<List<Integer>> result, List<Integer> currList, int[] nums) {
		if (currList.size() == nums.length) {
			result.add(new ArrayList<>(currList));
			return;
		}
		for (int num : nums) {
			if (currList.contains(num)) {
				continue; // Skip if the number is already in the current list
			}
			currList.add(num);
			traceBack(result, currList, nums);
			currList.remove(currList.size() - 1); // Backtrack
		}
	}

}
