package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestInterleavingString {

	private InterleavingString checker;

	@BeforeEach
	void setUp() {
		checker = new InterleavingString();
	}

	@Test
	public void testExample1() {
		assertTrue(checker.isInterleave("aab", "axy", "aaxaby"));
	}

	@Test
	public void testExample2() {
		assertFalse(checker.isInterleave("aab", "axy", "abaaxy"));
	}

	@Test
	public void testEmptyStrings() {
		assertTrue(checker.isInterleave("", "", ""));
	}

	@Test
	public void testOneEmpty() {
		assertTrue(checker.isInterleave("abc", "", "abc"));
		assertTrue(checker.isInterleave("", "abc", "abc"));
		assertFalse(checker.isInterleave("", "abc", "ab"));
	}

	@Test
	public void testEqualSplit() {
		assertTrue(checker.isInterleave("abc", "def", "adbcef"));
	}

	@Test
	public void testLargeFalseCase() {
		assertFalse(checker.isInterleave("abc", "def", "abcdefg"));
	}

}
