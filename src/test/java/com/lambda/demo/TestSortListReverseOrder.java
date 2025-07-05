package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSortListReverseOrder {

	private SortListReverseOrder sorter;

	@BeforeEach
	void setUp() throws Exception {
		sorter = new SortListReverseOrder();
	}

	@Test
	void testSortListInReverseOrderBasicCase() {
		List<String> input = Arrays.asList("apple", "banana", "cherry");
		List<String> expected = Arrays.asList("cherry", "banana", "apple");
		List<String> result = sorter.sortListInReverseOrder(input);
		assertEquals(expected, result);
	}

	@Test
	void testSortListInReverseOrderAlreadySorted() {
		List<String> input = Arrays.asList("z", "y", "x");
		List<String> expected = Arrays.asList("z", "y", "x");
		List<String> result = sorter.sortListInReverseOrder(input);
		assertEquals(expected, result);
	}

	@Test
	void testSortListInReverseOrderEmptyList() {
		List<String> input = Collections.emptyList();
		List<String> expected = Collections.emptyList();
		List<String> result = sorter.sortListInReverseOrder(input);
		assertEquals(expected, result);
	}

	@Test
	void testSortListInReverseOrderWithDuplicates() {
		List<String> input = Arrays.asList("apple", "banana", "apple");
		List<String> expected = Arrays.asList("banana", "apple", "apple");
		List<String> result = sorter.sortListInReverseOrder(input);
		assertEquals(expected, result);
	}

	@Test
	void testSortListInReverseOrderWithNulls() {
		List<String> input = Arrays.asList("banana", null, "apple");
		assertThrows(NullPointerException.class, () -> sorter.sortListInReverseOrder(input));
	}

	@Test
	void testSortListInReverseOrder_nullInput() {
		assertThrows(NullPointerException.class, () -> sorter.sortListInReverseOrder(null));
	}

}
