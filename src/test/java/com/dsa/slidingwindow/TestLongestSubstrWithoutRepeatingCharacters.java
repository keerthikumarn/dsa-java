package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.LongestSubstrWithoutRepeatingCharacters;

class TestLongestSubstrWithoutRepeatingCharacters {

	private LongestSubstrWithoutRepeatingCharacters finder;
	
	@BeforeEach
	void setUp() {
		finder = new LongestSubstrWithoutRepeatingCharacters();
	}
	
	@Test
	void testEmptyString() {
		assertEquals(0, finder.findLongestSubstrWithoutRepeatingCharacters(""));
	}

	@Test
	void testNoRepeatingCharacters() {
		assertEquals(7, finder.findLongestSubstrWithoutRepeatingCharacters("abcdefg"));
	}

	@Test
	void testAllRepeatingCharacters() {
		assertEquals(1, finder.findLongestSubstrWithoutRepeatingCharacters("aaaaaaa"));
	}

	@Test
	void testMixedCharacters() {
		assertEquals(3, finder.findLongestSubstrWithoutRepeatingCharacters("abcabcbb"));
	}

	@Test
	void testEndingWithLongestSubstring() {
		assertEquals(4, finder.findLongestSubstrWithoutRepeatingCharacters("aabcbde"));
	}

	@Test
	void testOriginalExample() {
		assertEquals(5, finder.findLongestSubstrWithoutRepeatingCharacters("abcbbcbbkhlkkmnhhgbabfds"));
	}

	@Test
	void testNumbersAndSymbols() {
		assertEquals(8, finder.findLongestSubstrWithoutRepeatingCharacters("a1b2c3d4"));
	}

	@Test
	void testLongStringWithSpaces() {
		assertEquals(7, finder.findLongestSubstrWithoutRepeatingCharacters("abc def ghi jkl"));
	}

}
