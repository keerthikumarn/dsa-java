package com.dsa.slidingiwindow;

public class CountDistinctElements {

	public static void main(String[] args) {
		System.out.println(countWindowDistinct(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
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
}