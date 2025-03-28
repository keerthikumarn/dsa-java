package com.dsa.slidingiwindow;

public class MinimumSizeSubArray {

	/*public static void main(String[] args) {
		System.out.println(minSum(new int[] { 2, 3, 1, 2, 4, 3 }, 7));
	}*/

	public int minSum(int arr[], int S) {
		int minLength = Integer.MAX_VALUE;
		int len = arr.length;
		int currSum = 0;
		int leftPtr = 0;
		for (int rightPtr = 0; rightPtr < len; rightPtr++) {
			currSum +=  arr[rightPtr];
			while (currSum >= S) {
				minLength = Math.min(minLength, rightPtr - leftPtr + 1);
				currSum -= arr[leftPtr];
				leftPtr++;
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
