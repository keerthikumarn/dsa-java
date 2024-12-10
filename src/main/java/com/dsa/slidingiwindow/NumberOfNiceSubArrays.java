package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class NumberOfNiceSubArrays {

	public static void main(String[] args) {
		System.out.println(numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
		System.out.println(numberOfSubarrays(new int[] { 2, 4, 6 }, 1));
		System.out.println(numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2));
	}

	private static int numberOfSubarrays(int[] nums, int k) {
		int oddNumCount = 0;
		int count = 0;
		Map<Integer, Integer> prefixMap = new HashMap<>();
		prefixMap.put(0, 1);
		for (int num : nums) {
			/* check the curr num in the array is odd number or not */
			if (num % 2 != 0) {
				oddNumCount++;
			}
			if (prefixMap.containsKey(oddNumCount - k)) {
				count += prefixMap.get(oddNumCount - k);
			}
			prefixMap.put(oddNumCount, prefixMap.getOrDefault(oddNumCount, 0) + 1);
		}
		return count;
	}

}
