package com.dsa.leetcode.samples;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		// Directions array for the 8 possible moves (horizontal, vertical, diagonal)
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Iterate through the board and store the new states temporarily
		for (int iIdx = 0; iIdx < m; iIdx++) {
			for (int jIdx = 0; jIdx < n; jIdx++) {
				int liveNeighbors = 0;

				// Count the live neighbors
				for (int k = 0; k < 8; k++) {
					int x = iIdx + dx[k];
					int y = jIdx + dy[k];
					if (x >= 0 && x < m && y >= 0 && y < n && Math.abs(board[x][y]) == 1) {
						liveNeighbors++;
					}
				}
				if (board[iIdx][jIdx] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
					board[iIdx][jIdx] = -1; // Mark as dead
				}
				if (board[iIdx][jIdx] == 0 && liveNeighbors == 3) {
					board[iIdx][jIdx] = 2; // Mark as alive
				}
			}
		}

		// Final transformation: Convert temporary states to their final values
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == -1)
					board[i][j] = 0;
				if (board[i][j] == 2)
					board[i][j] = 1;
			}
		}

	}
}
