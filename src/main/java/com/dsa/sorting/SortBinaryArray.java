package com.dsa.sorting;

import java.util.Arrays;

public class SortBinaryArray {

	public static void main(String[] args) {
		int[] binaryArray = { 1, 0, 1, 0, 1, 0, 0, 1 };
		sortBinaryArray(binaryArray);
		System.out.println("Sorted binary array: " + Arrays.toString(binaryArray));
	}

	public static void sortBinaryArray(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num == 0) {
				count++;
			}
		}
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = (idx < count) ? 0 : 1;
		}
	}

}
