package com.dsa.slidingiwindow;

public class SmallestSubArray {

	public static void main(String[] args) {
		System.out.println(smallestSubArrayWithSum(new int[] { 7 }, 8));
		System.out.println(smallestSubArrayWithSum(new int[] { 36 }, 23));
	}

	private static int smallestSubArrayWithSum(int arr[], int x) {
		int len = arr.length;
		int minLen = len + 1;
		for (int startPtr = 0; startPtr < len; startPtr++) {
			int currSum = arr[startPtr];
			if (currSum > x) {
				return currSum;
			}
			for (int endPtr = startPtr + 1; endPtr < len; endPtr++) {
				// add the last element to the currSum
				currSum += arr[endPtr];
				if (currSum > x && (endPtr - startPtr + 1) < minLen) {
					minLen = (endPtr - startPtr + 1);
				}
			}
		}
		return minLen;
	}

}
