package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTwoSum {
	
	private TwoSum obj;

	@BeforeEach
	void setUp() {
		obj = new TwoSum();
	}
	
	@Test
	void testTwoSum() {
		int[] num = { 3, 4, 5, 6 };
		int[] result = obj.twoSum(num, 7);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
	}
	
	@Test
	void testTwoSum_1() {
		int[] num = { 2, 7, 11, 15 };
		int[] result = obj.twoSum(num, 9);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
	}
	
	@Test
	void testTwoSum_2() {
		int[] num = { 3, 2, 4 };
		int[] result = obj.twoSum(num, 6);
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
	}
}
