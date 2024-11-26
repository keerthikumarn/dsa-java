package com.dsa.slidingiwindow;

public class SlidingWindow {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { 100, 200, 300, 400 }, 2));
		System.out.println(maxSum(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(maxSumSWApproach(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(maxSumSWApproach(new int[] { 100, 200, 300, 400 }, 2));
		System.out.println(maxSumSWApproach(new int[] { 1, 4, 2, 10, 2, 3, 1, 0, 20 }, 4));
	}

	/* Brute force approach */
	private static int maxSum(int arr[], int K) {
		int maxSum = Integer.MIN_VALUE;
		int len = arr.length;
		for (int leftPtr = 0; leftPtr < len - K + 1; leftPtr++) {
			int currSum = 0;
			for (int rightPtr = 0; rightPtr < K; rightPtr++) {
				currSum = currSum + arr[leftPtr + rightPtr];
			}
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

	private static int maxSumSWApproach(int arr[], int K) {
		int len = arr.length;
		if (len <= K) {
			return -1;
		}
		// compute the size of the first window
		int maxSum = 0;
		for (int idx = 0; idx < K; idx++) {
			maxSum += arr[idx];
		}
		System.out.println("Sum of first window computed: " + maxSum);
		/*
		 * compute the sum of remaining windows by removing the first element from the
		 * previous window
		 */
		int windowSum = maxSum;
		for (int idx = K; idx < len; idx++) {
			windowSum += arr[idx] - arr[idx - K];
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}

}
