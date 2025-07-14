package com.string.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStringOperations {

	private StringOperations ops;

	@BeforeEach
	void setUp() throws Exception {
		ops = new StringOperations();
	}

	@Test
	public void testCombinedLength() {
		assertEquals(10, ops.getCombinedLength("hello", "world"));
		assertEquals(6, ops.getCombinedLength("abc", "def"));
	}

	@Test
	public void testLexicographicalComparison() {
		assertEquals("Yes", ops.isLexicographicallyGreater("world", "hello"));
		assertEquals("No", ops.isLexicographicallyGreater("apple", "banana"));
		assertEquals("No", ops.isLexicographicallyGreater("abc", "abc")); // same strings
	}

	@Test
	public void testCapitalizeFirstLetters() {
		assertEquals("Hello World", ops.capitalizeFirstLetters("hello", "world"));
		assertEquals("Java Code", ops.capitalizeFirstLetters("java", "code"));
		assertEquals("A B", ops.capitalizeFirstLetters("a", "b"));
		assertEquals(" ", ops.capitalizeFirstLetters("",""));
	}

}
