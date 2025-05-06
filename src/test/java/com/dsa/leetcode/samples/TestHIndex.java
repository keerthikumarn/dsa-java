package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHIndex {

	private HIndex hIndex = null;

	@BeforeEach
	void setUp() {
		hIndex = new HIndex();
	}

	@Test
	public void testExample1() {
		int[] citations = { 3, 0, 6, 1, 5 };
		assertEquals(3, hIndex.hIndex(citations));
	}

	@Test
	public void testExample2() {
		int[] citations = { 3, 1, 1 };
		assertEquals(1, hIndex.hIndex(citations));
	}

	@Test
	public void testAllZeros() {
		int[] citations = { 0, 0, 0, 0 };
		assertEquals(0, hIndex.hIndex(citations));
	}

	@Test
	public void testSinglePaper() {
		int[] citations = { 10 };
		assertEquals(1, hIndex.hIndex(citations));
	}

	@Test
	public void testAllSameHighValues() {
		int[] citations = { 5, 5, 5, 5, 5 };
		assertEquals(5, hIndex.hIndex(citations));
	}

	@Test
	public void testIncreasingOrder() {
		int[] citations = { 0, 1, 2, 3, 4, 5 };
		assertEquals(3, hIndex.hIndex(citations));
	}

	@Test
	public void testEmptyArray() {
		int[] citations = {};
		assertEquals(0, hIndex.hIndex(citations));
	}

	@Test
	public void testDescendingOrder() {
		int[] citations = { 6, 5, 3, 1, 0 };
		assertEquals(3, hIndex.hIndex(citations));
	}

}
