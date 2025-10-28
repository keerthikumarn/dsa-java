package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSuperReducedString {

	private SuperReducedString superReducedString;

	@BeforeEach
	void setUp() throws Exception {
		superReducedString = new SuperReducedString();
	}

	@Test
	void returnsEmptyStringWhenInputIsEmpty() {
		String result = superReducedString.getReducedString("");
		assertEquals("", result);
	}

	@Test
	void returnsSameStringWhenNoAdjacentDuplicatesExist() {
		String result = superReducedString.getReducedString("abc");
		assertEquals("abc", result);
	}

	@Test
	void reducesStringWithSinglePairOfAdjacentDuplicates() {
		String result = superReducedString.getReducedString("aabb");
		assertEquals("", result);
	}

	@Test
	void reducesStringWithMultiplePairsOfAdjacentDuplicates() {
		String result = superReducedString.getReducedString("abba");
		assertEquals("", result);
	}

	@Test
	void reducesStringWithNestedAdjacentDuplicates() {
		String result = superReducedString.getReducedString("abccba");
		assertEquals("", result);
	}

	@Test
	void handlesStringWithNonConsecutiveDuplicates() {
		String result = superReducedString.getReducedString("abcabc");
		assertEquals("abcabc", result);
	}

	@Test
	void handlesStringWithMixedCaseCharacters() {
		String result = superReducedString.getReducedString("aAbB");
		assertEquals("aAbB", result);
	}

	@Test
	void reducesStringToEmptyWhenAllCharactersAreDuplicates() {
		String result = superReducedString.getReducedString("aa");
		assertEquals("", result);
	}

	@Test
	void reducesStringWithMultipleReductionsRequired() {
		String result = superReducedString.getReducedString("aaabccddd");
		assertEquals("abd", result);
	}

}
