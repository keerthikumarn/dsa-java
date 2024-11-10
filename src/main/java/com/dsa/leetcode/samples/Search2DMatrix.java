package com.dsa.leetcode.samples;

public class Search2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } }, 20));
	}

	/* Brute force approach */
	private static boolean searchMatrix(int[][] matrix, int target) {
		for (int rows = 0; rows < matrix.length; rows++) {
			for (int cols = 0; cols < matrix[rows].length; cols++) {
				if (matrix[rows][cols] == target) {
					return true;
				}
			}
		}
		return false;
	}

}
