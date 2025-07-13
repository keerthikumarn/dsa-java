package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestReverseOrderList {

	private ReverseOrderList reverseOrderList;

	@BeforeEach
	void setUp() throws Exception {
		reverseOrderList = new ReverseOrderList();
	}

	@Test
	public void testReverseOrder_NormalList() {
		List<Integer> input = Arrays.asList(5, 2, 9, 1, 3);
		List<Integer> expected = Arrays.asList(9, 5, 3, 2, 1);
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

	@Test
	public void testReverseOrder_AlreadyDescending() {
		List<Integer> input = Arrays.asList(10, 8, 6, 4, 2);
		List<Integer> expected = Arrays.asList(10, 8, 6, 4, 2);
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

	@Test
	public void testReverseOrder_WithDuplicates() {
		List<Integer> input = Arrays.asList(4, 2, 4, 3, 2);
		List<Integer> expected = Arrays.asList(4, 4, 3, 2, 2);
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

	@Test
	public void testReverseOrder_EmptyList() {
		List<Integer> input = Collections.emptyList();
		List<Integer> expected = Collections.emptyList();
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

	@Test
	public void testReverseOrder_SingleElement() {
		List<Integer> input = Collections.singletonList(42);
		List<Integer> expected = Collections.singletonList(42);
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

	@Test
	public void testReverseOrder_NegativeNumbers() {
		List<Integer> input = Arrays.asList(-3, -1, -7, -5);
		List<Integer> expected = Arrays.asList(-1, -3, -5, -7);
		assertEquals(expected, reverseOrderList.reverseOrder(input));
	}

}
