package com.dsa.leetcode.samples;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean firstRowZero = false;
		boolean firstColZero = false;

		// Check if first row has a zero
		for (int row = 0; row < cols; row++) {
			if (matrix[0][row] == 0) {
				firstColZero = true;
				break;
			}
		}

		// Check if first column has a zero
		for (int col = 0; col < rows; col++) {
			if (matrix[col][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		// Use first row and first column as markers
		for (int rIdx = 1; rIdx < rows; rIdx++) {
			for (int cIdx = 1; cIdx < cols; cIdx++) {
				if (matrix[rIdx][cIdx] == 0) {
					matrix[rIdx][0] = 0;
					matrix[0][cIdx] = 0;
				}
			}
		}

		// Zero out marked rows
		for (int rIdx = 1; rIdx < rows; rIdx++) {
			if (matrix[rIdx][0] == 0) {
				for (int cIdx = 1; cIdx < cols; cIdx++) {
					matrix[rIdx][cIdx] = 0;
				}
			}
		}

		// Zero out marked columns
		for (int cIdx = 1; cIdx < cols; cIdx++) {
			if (matrix[0][cIdx] == 0) {
				for (int rIdx = 1; rIdx < rows; rIdx++) {
					matrix[rIdx][cIdx] = 0;
				}
			}
		}

		// Zero out first row if needed
		if (firstRowZero) {
			for (int cIdx = 0; cIdx < cols; cIdx++) {
				matrix[0][cIdx] = 0;
			}
		}

		// Zero out first column if needed
		if (firstColZero) {
			for (int rIdx = 0; rIdx < rows; rIdx++) {
				matrix[rIdx][0] = 0;
			}
		}
	}

}
