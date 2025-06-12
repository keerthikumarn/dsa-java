package com.dsa.leetcode.samples;

public class KthSmallestInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];
		while (left < right) {
			int mid = left + (left - right) / 2;
			int count = countLessOrEqual(matrix, mid, n);
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private int countLessOrEqual(int[][] matrix, int mid, int n) {
		int count = 0;
		int row = n - 1;
		int col = 0;

		while (row >= 0 && col < n) {
			if (matrix[row][col] <= mid) {
				count += row + 1; // all elements in this column up to this row are <= mid
				col++;
			} else {
				row--;
			}
		}
		return count;
	}
}
