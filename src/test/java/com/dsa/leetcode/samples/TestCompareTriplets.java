package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCompareTriplets {

	private CompareTriplets solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new CompareTriplets();
	}

	@Test
	public void testExampleCase() {
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(3, 2, 1);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(1, 1), result);
		assertEquals(1, result.get(0)); // Alice's score
		assertEquals(1, result.get(1)); // Bob's score
	}

	@Test
	public void testAliceWinsAll() {
		List<Integer> a = Arrays.asList(100, 90, 80);
		List<Integer> b = Arrays.asList(50, 60, 70);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(3, 0), result);
	}

	@Test
	public void testBobWinsAll() {
		List<Integer> a = Arrays.asList(50, 60, 70);
		List<Integer> b = Arrays.asList(100, 90, 80);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(0, 3), result);
	}

	@Test
	public void testBothScoresAreEqual() {
		List<Integer> a = Arrays.asList(50, 50, 50);
		List<Integer> b = Arrays.asList(50, 50, 50);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(0, 0), result);
	}

	@Test
	public void testMixedScores() {
		List<Integer> a = Arrays.asList(17, 28, 30);
		List<Integer> b = Arrays.asList(99, 16, 8);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(2, 1), result);
	}

	@Test
	public void testMinimumValues() {
		List<Integer> a = Arrays.asList(1, 1, 1);
		List<Integer> b = Arrays.asList(1, 1, 1);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(0, 0), result);
	}

	@Test
	public void testMaximumValues() {
		List<Integer> a = Arrays.asList(100, 100, 100);
		List<Integer> b = Arrays.asList(100, 100, 100);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(0, 0), result);
	}

	@Test
	public void testExtremeValues() {
		List<Integer> a = Arrays.asList(1, 100, 50);
		List<Integer> b = Arrays.asList(100, 1, 50);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(1, 1), result);
	}

	@Test
	public void testEdgeCaseSequentialScores() {
		List<Integer> a = Arrays.asList(5, 6, 7);
		List<Integer> b = Arrays.asList(3, 6, 10);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(1, 1), result);
	}

	@Test
	public void testLargeNumbers() {
		List<Integer> a = Arrays.asList(99, 98, 97);
		List<Integer> b = Arrays.asList(96, 95, 94);
		List<Integer> result = solution.compareTriplets(a, b);
		assertEquals(Arrays.asList(3, 0), result);
	}

}
