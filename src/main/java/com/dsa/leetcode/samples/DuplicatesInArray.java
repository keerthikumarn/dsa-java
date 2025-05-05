package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesInArray {

	/*public static void main(String[] args) {
		List<Integer> resList = findDuplicates(Arrays.asList(12, 11, 40, 12, 5, 6, 5, 12, 11));
		for (int num : resList) {
			System.out.println(num);
		}
	}*/

	public List<Integer> findDuplicates(List<Integer> arr) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : arr) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		List<Integer> duplicatesList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > 1) {
				duplicatesList.add(entry.getKey());
			}
		}
		return duplicatesList;
	}

}
