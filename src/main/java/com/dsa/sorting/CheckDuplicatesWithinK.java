package com.dsa.sorting;

public class CheckDuplicatesWithinK {

	public boolean checkDuplicatesWithinK(int[] arr, int k) {
		int len = arr.length;
		for (int idx = 0; idx < len; idx++) {
			for (int c = 1; c <= k && (idx + c) < len; c++) {
				int nextIdx = idx + c;
				if (arr[idx] == arr[nextIdx]) {
					return true;
				}
			}
		}
		return false;
	}

}
