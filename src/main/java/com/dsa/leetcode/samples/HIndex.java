package com.dsa.leetcode.samples;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(hIndex(new int[] { 3, 1, 1 }));
	}

	private static int hIndex(int[] citations) {
		int len = citations.length;
		int hIndex = 0;
		Arrays.sort(citations);
		for (int idx = 0; idx < len; idx++) {
			int hValue = len - idx;
			if (citations[idx] >= hValue) {
				hIndex = hValue;
				break;
			}
		}
		return hIndex;
	}

}
