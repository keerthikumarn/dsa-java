package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDuplicatesInArray {

	private DuplicatesInArray duplicatesInArray;

	@BeforeEach
	void setUp() {
		duplicatesInArray = new DuplicatesInArray();
	}

	@Test
	public void testMultipleDuplicates() {
		List<Integer> input = Arrays.asList(12, 11, 40, 12, 5, 6, 5, 12, 11);
		List<Integer> expected = Arrays.asList(12, 11, 5);
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(new HashSet<>(expected), new HashSet<>(actual));
	}

	@Test
	public void testNoDuplicates() {
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> expected = Collections.emptyList();
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testAllDuplicates() {
		List<Integer> input = Arrays.asList(9, 9, 9, 9);
		List<Integer> expected = Arrays.asList(9);
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyList() {
		List<Integer> input = Collections.emptyList();
		List<Integer> expected = Collections.emptyList();
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testSingleElement() {
		List<Integer> input = Arrays.asList(42);
		List<Integer> expected = Collections.emptyList();
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testNegativeAndPositiveNumbers() {
		List<Integer> input = Arrays.asList(-1, 2, -1, 3, 2, 4);
		List<Integer> expected = Arrays.asList(-1, 2);
		List<Integer> actual = duplicatesInArray.findDuplicates(input);
		assertEquals(new HashSet<>(expected), new HashSet<>(actual));
	}

}
