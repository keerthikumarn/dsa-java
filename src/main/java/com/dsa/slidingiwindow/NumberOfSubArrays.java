package com.dsa.slidingiwindow;

public class NumberOfSubArrays {

	public static void main(String[] args) {
		System.out.println(numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));
	}

	private static int numOfSubarrays(int[] arr, int k, int threshold) {
		int len = arr.length;
		int arrSum = 0;
		int numOfSubarrays = 0;
		for (int idx = 0; idx < k; idx++) {
			arrSum += arr[idx];
		}
		System.out.println(arrSum);
		if (arrSum / k >= threshold) {
			numOfSubarrays++;
		}
		for (int idx = k; idx < len; idx++) {
			arrSum += arr[idx] - arr[idx - k];
			if (arrSum / k >= threshold) {
				numOfSubarrays++;
			}
		}
		return numOfSubarrays;
	}

}
