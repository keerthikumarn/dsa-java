package com.dsa.leetcode.samples;

public class SlidingWindow {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { 100, 200, 300, 400 }, 2));
	}

	private static int maxSum(int arr[], int k) {
		int maxSum = Integer.MIN_VALUE;
		int len = arr.length;
		for (int leftPtr = 0; leftPtr < len - k + 1; leftPtr++) {
			int currSum = 0;
			for (int rightPtr = 0; rightPtr < k; rightPtr++) {
				currSum = currSum + arr[leftPtr + rightPtr];
			}
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

}
