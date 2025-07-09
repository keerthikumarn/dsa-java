package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMinimumElementInList {

	private MinimumElementInList minFinder;

	@BeforeEach
	void setUp() throws Exception {
		minFinder = new MinimumElementInList();
	}

	@Test
	void testFindMinWithPositiveNumbers() {
		List<Integer> numbers = Arrays.asList(10, 5, 8, 3, 15);
		int result = minFinder.findMinElement(numbers);
		assertEquals(3, result);
	}

	@Test
	void testFindMinWithNegativeNumbers() {
		List<Integer> numbers = Arrays.asList(-1, -5, -3, 0, 2);
		int result = minFinder.findMinElement(numbers);
		assertEquals(-5, result);
	}

	@Test
	void testFindMinWithSingleElement() {
		List<Integer> numbers = Collections.singletonList(42);
		int result = minFinder.findMinElement(numbers);
		assertEquals(42, result);
	}

	@Test
	void testFindMinWithEmptyList() {
		List<Integer> numbers = Collections.emptyList();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			minFinder.findMinElement(numbers);
		});
		assertEquals("List cannot be null or empty", exception.getMessage());
	}

	@Test
	void testFindMinWithNullList() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			minFinder.findMinElement(null);
		});
		assertEquals("List cannot be null or empty", exception.getMessage());
	}

}
