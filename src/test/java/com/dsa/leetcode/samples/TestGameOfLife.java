package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGameOfLife {

	private GameOfLife game;
	
	@BeforeEach
	void setUp() {
		game = new GameOfLife();
	}

	// Helper method to compare boards
	private void assertBoardsEqual(int[][] expected, int[][] actual) {
		assertEquals(expected.length, actual.length, "Row size mismatch");
		assertEquals(expected[0].length, actual[0].length, "Column size mismatch");
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i], "Mismatch at row " + i);
		}
	}

	@Test
	public void testGameOfLifeNormalScenario() {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		int[][] expected = { { 0, 0, 0 }, { 1, 0, 1 }, { 0, 1, 1 }, { 0, 1, 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeAllDeadCells() {
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeAllLiveCells() {
		int[][] board = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][] expected = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeSmallGrid() {
		int[][] board = { { 1, 1 }, { 1, 0 } };
		int[][] expected = { { 1, 1 }, { 1, 1 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeSingleCell() {
		int[][] board = { { 1 } };
		int[][] expected = { { 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeLargeGrid() {
		int[][] board = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
		int[][] expected = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeEmptyGrid() {
		int[][] board = new int[0][0];
		int[][] expected = new int[0][0];
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeOneRowGrid() {
		int[][] board = { { 1, 1, 0, 1, 0 } };
		int[][] expected = { { 0, 0, 0, 0, 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeOneColumnGrid() {
		int[][] board = { { 1 }, { 1 }, { 0 }, { 1 }, { 0 } };
		int[][] expected = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}

	@Test
	public void testGameOfLifeStableState() {
		int[][] board = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int[][] expected = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		game.gameOfLife(board);
		assertBoardsEqual(expected, board);
	}
}
