package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

	public boolean isValidSudoku(char[][] board) {
		Set<Character>[] rowSet = new HashSet[9];
		Set<Character>[] colSet = new HashSet[9];
		Set<Character>[] boxSet = new HashSet[9];
		
		for (int idx = 0; idx < 9; idx++) {
            rowSet[idx] = new HashSet<>();
            colSet[idx] = new HashSet<>();
            boxSet[idx] = new HashSet<>();
        }
		
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
                char current = board[row][col];
                if(current == '.') {
                	continue;
                }
                int boxIndex = (row / 3) * 3 + (col / 3);
                if(rowSet[row].contains(current) || colSet[col].contains(current) 
                		|| boxSet[boxIndex].contains(current)) {
                    return false;
                }
                rowSet[row].add(current);
                colSet[col].add(current);
                boxSet[boxIndex].add(current);
            }
		}
		return true;
	}

}
