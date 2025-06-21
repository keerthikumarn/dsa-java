package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			result.add(new ArrayList<>()); 
			return result;
		}
		traceBack(result, new ArrayList<>(), nums);
		return result;
	}

	private void traceBack(List<List<Integer>> result, List<Integer> currList, int[] nums) {
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
