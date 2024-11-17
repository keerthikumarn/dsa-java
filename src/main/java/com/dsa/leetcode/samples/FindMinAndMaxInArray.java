package com.dsa.leetcode.samples;

public class FindMinAndMaxInArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9 };
		int minNumInArray = findMinNumInArray(arr, arr.length);
		int maxNumInArray = findMaxNumInArray(arr, arr.length);
		System.out.println("Minimum is: " + minNumInArray + " and Maximum is: " + maxNumInArray);
	}

	private static int findMinNumInArray(int[] arr, int len) {
		int minNum = Integer.MAX_VALUE;
		for (int idx = 0; idx < len; idx++) {
			if (arr[idx] < minNum) {
				minNum = arr[idx];
			}
		}
		return minNum;
	}

	private static int findMaxNumInArray(int[] arr, int len) {
		int maxNum = Integer.MIN_VALUE;
		for (int idx = 0; idx < len; idx++) {
			if (arr[idx] > maxNum) {
				maxNum = arr[idx];
			}
		}
		return maxNum;
	}

}
