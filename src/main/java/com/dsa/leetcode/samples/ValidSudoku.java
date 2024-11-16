package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	private static boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] boxes = new boolean[9][9];

		for (int iIndex = 0; iIndex < 9; iIndex++) {
			for (int jIndex = 0; jIndex < 9; jIndex++) {
				char num = board[iIndex][jIndex];
				if (num == '.') {
					continue;
				}
				int number = num - '1';
				int boxIndex = (iIndex / 3) * 3 + (jIndex / 3);
				if (rows[iIndex][number] || cols[jIndex][number] || boxes[boxIndex][number]) {
					return false;
				}
				rows[iIndex][number] = true;
				cols[jIndex][number] = true;
				boxes[boxIndex][number] = true;
			}
		}
		return true;
	}
	
	private static boolean isValidSudokuHashSetApproach(char[][] board) {
		Set<String> visited = new HashSet<>();
		for (int iIndex = 0; iIndex < 9; iIndex++) {
			for (int jIndex = 0; jIndex < 9; jIndex++) {
				if(board[iIndex][jIndex] != '.') {
					String box = "("+board[iIndex][jIndex]+")";
					if(!visited.add(box + iIndex) ||!visited.add(jIndex + box) || !visited.add(iIndex/3 + box + jIndex/3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	

}
