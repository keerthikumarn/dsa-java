package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestRotateImage {

	private RotateImage image;

	@BeforeEach
	void setUp() {
		image = new RotateImage();
	}

	@Test
	public void testRotate3x3Matrix() {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		image.rotate(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testRotate4x4Matrix() {
		int[][] input = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		int[][] expected = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		image.rotate(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testRotate1x1Matrix() {
		int[][] input = { { 42 } };
		int[][] expected = { { 42 } };
		image.rotate(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testRotate2x2Matrix() {
		int[][] input = { { 1, 2 }, { 3, 4 } };
		int[][] expected = { { 3, 1 }, { 4, 2 } };
		image.rotate(input);
		assertArrayEquals(expected, input);
	}

}
