package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an m x n matrix, return all elements of the matrix in
 * spiral order.
 */
public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		while (top <= bottom && left <= right) {

			// Traverse from left right
			for (int idx = left; idx <= right; idx++) {
				result.add(matrix[top][idx]);
			}
			top++;

			// Traverse right column (top to bottom)
			for (int idx = top; idx <= bottom; idx++) {
				result.add(matrix[idx][right]);
			}
			right--;

			// Traverse bottom row (right to left), only if there are remaining rows
			if (top <= bottom) {
				for (int idx = right; idx >= left; idx--) {
					result.add(matrix[bottom][idx]);
				}
				bottom--;
			}

			// Traverse left column (bottom to top), only if there are remaining columns
			if (left <= right) {
				for (int idx = bottom; idx >= top; idx--) {
					result.add(matrix[idx][left]);
				}
				left++;
			}
		}
		return result;
	}
}
