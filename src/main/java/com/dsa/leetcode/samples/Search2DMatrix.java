package com.dsa.leetcode.samples;

public class Search2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } }, 20));
		System.out.println(searchMatrixBSApproach(new int[][] { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } }, 20));
	}

	/* Brute force approach */
	private static boolean searchMatrix(int[][] matrix, int target) {
		for (int rows = 0; rows < matrix.length; rows++) {
			for (int cols = 0; cols < matrix[rows].length; cols++) {
				if (matrix[rows][cols] == target) {
					System.out.println("Target element: " + target + " is found");
					return true;
				}
			}
		}
		return false;
	}

	/* Binary Search approach */
	private static boolean searchMatrixBSApproach(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int left = 0;
		int right = rows * cols - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (target > matrix[row][col]) {
				left = mid + 1;
			} else if (target < matrix[row][col]) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
