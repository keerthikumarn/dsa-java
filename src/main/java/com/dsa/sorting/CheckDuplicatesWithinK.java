package com.dsa.sorting;

public class CheckDuplicatesWithinK {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
		System.out.println(checkDuplicatesWithinK(arr, 3) ? "Yes" : "No");
	}

	private static boolean checkDuplicatesWithinK(int[] arr, int k) {
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
