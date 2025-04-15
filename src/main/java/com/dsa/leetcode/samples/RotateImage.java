package com.dsa.leetcode.samples;

public class RotateImage {

	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int iIdx = 0; iIdx < len; iIdx++) {
			for (int jIdx = iIdx + 1; jIdx < len; jIdx++) {
				int temp = matrix[iIdx][jIdx];
				matrix[iIdx][jIdx] = matrix[jIdx][iIdx];
				matrix[jIdx][iIdx] = temp;
			}
		}
		// reverse the array
		for (int idx = 0; idx < len; idx++) {
			reverseArray(matrix[idx]);
		}
	}

	private void reverseArray(int[] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
	}

}
	