package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] num = { 3, 4, 5, 6 };
		twoSum(num, 7);
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int idx = 0; idx < nums.length; idx++) {
			numMap.put(nums[idx], idx);
		}
		for (int index = 0; index < nums.length; index++) {
            int sum = target - nums[index];
            if (numMap.containsKey(sum) && numMap.get(sum) != index) {
                return new int[]{index, numMap.get(sum)};
            }
        }
		return null;
	}

}
