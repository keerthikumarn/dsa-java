package com.dsa.slidingiwindow;

public class FirstNegativeInteger {

	public static void main(String[] args) {
		printFirstNegativeInteger(new int[] { 12, -1, -7, 8, -15, 30, 16, 28 }, 3);
	}

	private static void printFirstNegativeInteger(int arr[], int K) {
		boolean isNegativeInteger = false;
		int len = arr.length;
		for (int iIdx = 0; iIdx < (len - K + 1); iIdx++) {
			for (int jIdx = 0; jIdx < K; jIdx++) {
				if (arr[iIdx + jIdx] < 0) {
					isNegativeInteger = true;
					System.out.print((arr[iIdx + jIdx])+" ");
					break;
				}
			}
		}
		if (!isNegativeInteger) {
			System.out.println("0" + "");
		}
	}
}
