package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class MostFrequentElementsInArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3 };
		System.out.println(topKFrequent(nums, 2));
	}

	private static Object[] topKFrequent(int[] nums, int k) {
		List<Integer> elementsWithMaxFrequent = new ArrayList<>();
		int maxFreqCount = 0;
		for (int iRow = 0; iRow < k; iRow++) {
			int tempCount = 0;
			for (int jRow = 0; jRow < k; jRow++) {
				if (nums[iRow] == nums[jRow]) {
					tempCount++;
				}
				if (tempCount > maxFreqCount) {
					maxFreqCount = tempCount;
					elementsWithMaxFrequent.add(nums[iRow]);
				}
			}
		}
		return elementsWithMaxFrequent.toArray();
	}

}
