package com.dsa.twopointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestStringReverse {

	private final StringReverse stringReverse = new StringReverse();

	@Test
	void testReverseRegularString() {
		assertEquals("dcba", stringReverse.strReverse("abcd"), "Reversing a regular string failed");
	}

	@Test
	void testReverseSingleCharacter() {
		assertEquals("a", stringReverse.strReverse("a"), "Reversing a single character failed");
	}

	@Test
	void testReverseEmptyString() {
		assertEquals("", stringReverse.strReverse(""), "Reversing an empty string failed");
	}

	@Test
	void testReversePalindromeString() {
		assertEquals("madam", stringReverse.strReverse("madam"), "Reversing a palindrome string failed");
	}

	@Test
	void testReverseStringWithSpaces() {
		assertEquals("dlrow olleh", stringReverse.strReverse("hello world"), "Reversing a string with spaces failed");
	}

	@Test
	void testReverseStringWithSpecialCharacters() {
		assertEquals("!dlroW ,olleH", stringReverse.strReverse("Hello, World!"),
				"Reversing a string with special characters failed");
	}

	@Test
	void testReverseStringWithNumbers() {
		assertEquals("321cba", stringReverse.strReverse("abc123"), "Reversing a string with numbers failed");
	}

	@Test
	void testReverseStringWithMixedCase() {
		assertEquals("dCbA", stringReverse.strReverse("AbCd"), "Reversing a mixed-case string failed");
	}

	@Test
	void testReverseStringWithWhitespaceOnly() {
		assertEquals("   ", stringReverse.strReverse("   "), "Reversing a whitespace-only string failed");
	}

	@Test
	void testReverseNullString() {
		assertThrows(NullPointerException.class, () -> stringReverse.strReverse(null),
				"Reversing a null string should throw NullPointerException");
	}
}
