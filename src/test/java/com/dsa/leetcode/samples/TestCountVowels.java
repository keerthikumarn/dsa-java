package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCountVowels {

	private final CountVowels counter = new CountVowels();

	@Test
	public void testAllVowels() {
		String input = "aeiouAEIOU";
		int result = counter.countVowels(input);
		assertEquals(10, result);
	}

	@Test
	public void testNoVowels() {
		String input = "bcdfg";
		int result = counter.countVowels(input);
		assertEquals(0, result);
	}

	@Test
	public void testMixedCharacters() {
		String input = "Hello World";
		int result = counter.countVowels(input);
		assertEquals(3, result); // e, o, o
	}

	@Test
	public void testEmptyString() {
		String input = "";
		int result = counter.countVowels(input);
		assertEquals(0, result);
	}

	@Test
	public void testUpperCaseOnly() {
		String input = "XYZOU";
		int result = counter.countVowels(input);
		assertEquals(2, result); // O, U
	}

	@Test
	public void testNullInput() {
		assertThrows(NullPointerException.class, () -> counter.countVowels(null));
	}

}
