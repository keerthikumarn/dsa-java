package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElements {

	public static void main(String[] args) {
		System.out.println(countWindowDistinct(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
		System.out.println(countWindowDistinctSW(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
	}

	/* Brute force approach */
	private static int countWindowDistinct(int win[], int K) {
		int distinctCount = 0;
		for (int iIdx = 0; iIdx < K; iIdx++) {
			int jIdx;
			for (jIdx = 0; jIdx < K; jIdx++) {
				if (win[iIdx] == win[jIdx]) {
					break;
				}
			}
			if (jIdx == iIdx) {
				distinctCount++;
			}
		}
		return distinctCount;
	}

	/* Sliding window approach */
	private static int countWindowDistinctSW(int win[], int K) {
		Map<Integer, Integer> map = new HashMap<>();
		// loop thru the 1st window and get the count
		for (int idx = 0; idx < K; idx++) {
			map.put(win[idx], map.getOrDefault(win[idx], 0) + 1);
		}
		// loop thru the remaining array
		for (int idx = K; idx < win.length; idx++) {
			// remove the 1st element from the previous window
			if (map.get(win[idx - K]) == 1) {
				map.remove(win[idx - K]);
			} else {
				// reduce the count of the remaining element
				map.put(win[idx - K], map.get(win[idx - K]) - 1);
			}
			map.put(win[idx], map.getOrDefault(win[idx], 0) + 1);
		}
		return map.size();
	}
}