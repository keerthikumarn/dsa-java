package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaxElementInList {

	private MaxElementInList maxFinder;

	@BeforeEach
	void setUp() throws Exception {
		maxFinder = new MaxElementInList();
	}

	@Test
	void testFindMaxWithPositiveNumbers() {
		List<Integer> numbers = Arrays.asList(10, 5, 8, 3, 15);
		int result = maxFinder.findMaxElement(numbers);
		assertEquals(15, result);
	}

	@Test
	void testFindMaxWithNegativeNumbers() {
		List<Integer> numbers = Arrays.asList(-1, -5, -3, 0, 2);
		int result = maxFinder.findMaxElement(numbers);
		assertEquals(2, result);
	}

	@Test
	void testFindMaxWithSingleElement() {
		List<Integer> numbers = Collections.singletonList(56);
		int result = maxFinder.findMaxElement(numbers);
		assertEquals(56, result);
	}

	@Test
	void testFindMaxWithEmptyList() {
		List<Integer> numbers = Collections.emptyList();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			maxFinder.findMaxElement(numbers);
		});
		assertEquals("List cannot be null or empty", exception.getMessage());
	}

	@Test
	void testFindMaxWithNullList() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			maxFinder.findMaxElement(null);
		});
		assertEquals("List cannot be null or empty", exception.getMessage());
	}
}
