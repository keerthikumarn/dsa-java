package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCountVowels {

	private final CountVowels counter = new CountVowels();

	@Test
	public void testAllVowels() {
		String input = "aeiouAEIOU";
		assertEquals(10, counter.countVowels(input));
	}

	@Test
	public void testNoVowels() {
		String input = "bcdfg";
		assertEquals(0, counter.countVowels(input));
	}

	@Test
	public void testMixedCharacters() {
		String input = "Hello World";
		assertEquals(3, counter.countVowels(input));
	}

	@Test
	public void testEmptyString() {
		String input = "";
		assertEquals(0, counter.countVowels(input));
	}

	@Test
	public void testUpperCaseOnly() {
		String input = "XYZOU";
		assertEquals(2, counter.countVowels(input)); // O, U
	}

	@Test
	public void testNullInput() {
		assertThrows(NullPointerException.class, () -> counter.countVowels(null));
	}

}
