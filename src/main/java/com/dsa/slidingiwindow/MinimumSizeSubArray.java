package com.dsa.slidingiwindow;

public class MinimumSizeSubArray {

	public static void main(String[] args) {
		System.out.println(minSum(new int[] { 2, 3, 1, 2, 4, 3 }, 7));
	}

	private static int minSum(int arr[], int S) {
		int minSum = Integer.MAX_VALUE;
		int len = arr.length;
		int currSum = 0;
		int leftPtr = 0;
		for (int rightPtr = 0; rightPtr < len; rightPtr++) {
			currSum += currSum + arr[rightPtr];
			while (currSum >= S) {
				minSum = Math.min(minSum, rightPtr - leftPtr + 1);
				currSum -= arr[leftPtr];
				leftPtr--;
			}
		}
		return minSum == Integer.MAX_VALUE ? 0 : minSum;
		;
	}
}
