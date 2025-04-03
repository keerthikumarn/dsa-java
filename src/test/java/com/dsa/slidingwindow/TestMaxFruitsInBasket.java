package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.MaxFruitsInBasket;

class TestMaxFruitsInBasket {

	private MaxFruitsInBasket basket;

	@BeforeEach
	public void setUp() {
		basket = new MaxFruitsInBasket();
	}

	@Test
	public void testExampleCase1() {
		int[] tree = { 1, 2, 1 };
		assertEquals(3, basket.totalFruit(tree));
	}

	@Test
	public void testExampleCase2() {
		int[] tree = { 0, 1, 2, 2 };
		assertEquals(3, basket.totalFruit(tree));
	}

	@Test
	public void testExampleCase3() {
		int[] tree = { 1, 2, 3, 2, 2 };
		assertEquals(4, basket.totalFruit(tree));
	}

	@Test
	public void testExampleCase4() {
		int[] tree = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		assertEquals(5, basket.totalFruit(tree));
	}

	@Test
	public void testSingleElement() {
		int[] tree = { 1 };
		assertEquals(1, basket.totalFruit(tree));
	}

	@Test
	public void testTwoFruitsOnly() {
		int[] tree = { 1, 1, 1, 2, 2, 2 };
		assertEquals(6, basket.totalFruit(tree));
	}

	@Test
	public void testAllSameFruit() {
		int[] tree = { 5, 5, 5, 5, 5 };
		assertEquals(5, basket.totalFruit(tree));
	}

	@Test
	public void testEmptyTree() {
		int[] tree = {};
		assertEquals(0, basket.totalFruit(tree));
	}

	@Test
	public void testThreeFruitsAlternating() {
		int[] tree = { 1, 2, 3, 1, 2 };
		assertEquals(2, basket.totalFruit(tree));
	}

}
