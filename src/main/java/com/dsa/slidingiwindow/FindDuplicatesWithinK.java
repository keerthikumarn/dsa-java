package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesWithinK {

	/*public static void main(String[] args) {
		System.out.println(findDuplicatesWithinK(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(findDuplicatesWithinK(new int[] { 4, 5, 6, 7 }, 3));
	}*/

	public boolean findDuplicatesWithinK(int[] nums, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int len = nums.length;
		for (int idx = 0; idx < len; idx++) {
			if (map.containsKey(nums[idx]) && (idx - map.get(nums[idx]) <= K)) {
				return true;
			} else {
				map.put(nums[idx], idx);
			}
		}
		return false;
	}

}
