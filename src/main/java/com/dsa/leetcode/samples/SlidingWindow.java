package com.dsa.leetcode.samples;

public class SlidingWindow {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { 100, 200, 300, 400 }, 2));
	}

	private static int maxSum(int arr[], int k) {
		int maxSum = Integer.MIN_VALUE;
		int len = arr.length;
		for (int iIdx = 0; iIdx < len - k + 1; iIdx++) {
			int currSum = 0;
			for (int jIdx = 0; jIdx < k; jIdx++) {
				currSum = currSum + arr[iIdx + jIdx];
			}
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

}
