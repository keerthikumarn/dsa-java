package com.dsa.slidingiwindow;

public class CountDistinctElements {

	/*public static void main(String[] args) {
		System.out.println(countWindowDistinct(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
		System.out.println(countWindowDistinctSW(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
	}*/

	/* Brute force approach */
	public int countWindowDistinct(int win[], int K) {
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
	/*private static int countWindowDistinctSW(int win[], int K) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int idx = 0; idx < K; idx++) {
			map.put(win[idx], map.getOrDefault(win[idx], 0) + 1);
		}
		for (int idx = K; idx < win.length; idx++) {
			if (map.get(win[idx - K]) == 1) {
				map.remove(win[idx - K]);
			} else {
				map.put(win[idx - K], map.get(win[idx - K]) - 1);
			}
			map.put(win[idx], map.getOrDefault(win[idx], 0) + 1);
		}
		return map.size();
	}*/
}