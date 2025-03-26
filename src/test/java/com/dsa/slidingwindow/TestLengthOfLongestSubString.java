package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.LengthOfLongestSubString;

class TestLengthOfLongestSubString {

	private LengthOfLongestSubString obj;

	@BeforeEach
	void setUp() {
		obj = new LengthOfLongestSubString();
	}

	@Test
	void testUniqueCharacters() {
		assertEquals(7, obj.lengthOfLongestSubString("abcdefg"));
	}

	@Test
	void testRepeatedCharacters() {
		assertEquals(3, obj.lengthOfLongestSubString("abcabcbb"));
	}

	@Test
	void testSingleCharacter() {
		assertEquals(1, obj.lengthOfLongestSubString("aaaa"));
	}

	@Test
	void testEmptyString() {
		assertEquals(0, obj.lengthOfLongestSubString(""));
	}

	@Test
	void testMixedCharacters() {
		assertEquals(5, obj.lengthOfLongestSubString("keerthi"));
	}

}
